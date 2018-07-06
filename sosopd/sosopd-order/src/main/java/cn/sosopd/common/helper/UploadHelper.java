package cn.sosopd.common.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import cn.sosopd.common.exception.ServiceRuntimeException;
import cn.sosopd.common.util.SystemProperties;

/**
 * 文件上传管理器
 * 
 * @author Chen Feng
 * @date 2015/01/19
 */
public abstract class UploadHelper {

    private static Logger log = Logger.getLogger(UploadHelper.class);

    /**
     * Web路径分隔符
     */
    public static final String WEB_PATH_SEPARATOR = "/";

    /**
     * 保存上传文件和图片的根路径
     */
    public static final String UPLOAD_ROOT_PATH;

    /**
     * 默认的保存上传文件和图片的根路径
     */
    private static final String DEFAULT_UPLOAD_ROOT_PATH = "C:\\weixiuhui_upload";

    /**
     * 初始化，根据配置文件获取文件上传根目录
     */
    static {
        String uploadRootPath = null;

        // 读取上传文件根目录的配置项
        String uploadRootPathProp = SystemProperties.getProperty("upload.rootpath");
        if (StringUtils.isNotBlank(uploadRootPathProp)) {
            uploadRootPath = makeUploadRootDir(uploadRootPathProp);
        }

        if (uploadRootPath != null) {
            UPLOAD_ROOT_PATH = uploadRootPath;
        } else {
            // 上传文件根目录的配置项加载失败或目录创建失败，则使用默认上传文件根目录
            uploadRootPath = makeUploadRootDir(DEFAULT_UPLOAD_ROOT_PATH);

            if (uploadRootPath != null) {
                final String message = "上传文件根目录的配置项加载失败或目录创建失败，将使用默认的上传文件根目录：" + DEFAULT_UPLOAD_ROOT_PATH;
                log.error(message);
                System.err.println(message);

                UPLOAD_ROOT_PATH = uploadRootPath;
            } else {
                // 默认的上传文件根目录也创建失败，系统将无法支持文件的上传和下载功能
                final String message = "默认的上传文件根目录创建失败，系统将无法支持文件的上传和下载功能：" + DEFAULT_UPLOAD_ROOT_PATH;
                log.error(message);
                System.err.println(message);

                UPLOAD_ROOT_PATH = null;
            }
        }
    }

    /**
     * 创建上传文件根目录
     * 
     * @param uploadRootPath
     * @return
     */
    private static String makeUploadRootDir(String uploadRootPath) {
        File rootPathDir = new File(uploadRootPath);
        if (rootPathDir.exists()) {
            // 配置项指向的路径已存在并且是目录
            if (rootPathDir.isDirectory()) {
                return uploadRootPath;
            }
        } else {
            try {
                // 配置项指向的路径不存在则创建目录
                if (rootPathDir.mkdirs()) {
                    return uploadRootPath;
                }
            } catch (Exception e) {
                log.error("创建上传文件根目录失败：" + uploadRootPath, e);
            }
        }
        return null;
    }

    /**
     * 获取上传根目录
     */
    public static String getUploadRootPath() {
        return UPLOAD_ROOT_PATH;
    }

    /**
     * 根据相对路径获取完整路径
     */
    public static String getFullFilePath(String relativeFilePath) {
        if (relativeFilePath.startsWith(File.separator)) {
            return getUploadRootPath() + relativeFilePath;
        } else {
            return getUploadRootPath() + File.separator + relativeFilePath;
        }
    }

    /**
     * 保存上传文件
     * 
     * <pre>
     * 示例 ： （假设上传文件后缀名为png）
     * <li>filePathParts为： {"platform", "sample"}， fileName为： headPortrait， 则文件路径为： platform/sample/headPortrait.png</li>
     * <li>filePathParts为： {"platform", "sample"}， fileName为： headPortrait.png， 则文件路径为： platform/sample/headPortrait.png</li>
     * </pre>
     * 
     * @param inputStream
     *            上传文件的流
     * @param pathParts
     *            指定的多级目录
     * @param fullFileName
     *            指定的文件名，包含后缀名
     * @return 上传文件的相对路径
     * @throws Exception
     */
    public static String saveFile(InputStream inputStream, String[] pathParts, String fullFileName) throws Exception {
        // Web根目录
        String rootDirPath = getUploadRootPath();

        File rootDir = new File(rootDirPath);
        if (!rootDir.exists()) {
            rootDir.mkdirs();
        } else if (rootDir.exists()) {
            if (!rootDir.isDirectory()) {
                System.out.println("文件上传根目录指定错误：" + rootDirPath);
                throw new Exception("文件上传根目录指定错误：" + rootDirPath);
            }
        }

        // 文件相对目录
        String relativeDirPath = "";
        if (pathParts != null && pathParts.length > 0) {
            for (String pathPart : pathParts) {
                relativeDirPath += File.separator + pathPart;
            }
        }

        // 文件完整目录
        String fullDirPath = rootDirPath + relativeDirPath;
        File fullDir = new File(fullDirPath);
        if (!fullDir.exists()) {
            fullDir.mkdirs();
        } else if (fullDir.exists()) {
            if (!fullDir.isDirectory()) {
                System.out.println("文件上传目录指定错误：" + rootDirPath);
                throw new Exception("文件上传目录指定错误：" + fullDirPath);
            }
        }

        // 文件相对路径
        String relativeFilePath = relativeDirPath + File.separator + fullFileName;

        String fullFilePath = rootDirPath + relativeFilePath;
        try {
            writeToFile(inputStream, fullFilePath);

            return StringUtils.replace(relativeFilePath, File.separator, WEB_PATH_SEPARATOR);
        } catch (Exception e) {
            log.error("保存文件出错", e);
            throw new Exception("保存文件出错：" + e.getMessage(), e);
        }
    }

    private static void writeToFile(InputStream inputstream, String filepath) throws Exception {
        OutputStream out = null;
        try {
            out = new FileOutputStream(new File(filepath));
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(filepath));
            while ((read = inputstream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            log.error("保存文件出错", e);
            throw new Exception("保存文件出错：" + e.getMessage(), e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error("关闭文件流出错", e);
                }
            }
        }
    }

    /**
     * 保存上传文件
     * 
     * <pre>
     * 示例 ： （假设上传文件后缀名为png）
     * <li>filePathParts为： {"platform", "sample"}， fileName为： headPortrait， 则文件路径为： platform/sample/headPortrait.png</li>
     * <li>filePathParts为： {"platform", "sample"}， fileName为： headPortrait.png， 则文件路径为： platform/sample/headPortrait.png</li>
     * </pre>
     * 
     * @param mpfile
     * @param filePathParts
     *            保存文件的目录名，可以指定任意多个，也可以不指定
     * @param fileName
     *            指定的新文件名（不需要包含后缀名）
     * @return 保存上传文件的相对路径
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String transferFile(MultipartFile mpfile, String[] filePathParts, String fileName)
            throws IllegalStateException, IOException {
        String relativeFilePath = transfer(mpfile, filePathParts, fileName);
        if (!relativeFilePath.startsWith(WEB_PATH_SEPARATOR)) {
            relativeFilePath = WEB_PATH_SEPARATOR + relativeFilePath;
        }
        return relativeFilePath;
    }

    /**
     * 获得上传文件的相对路径
     * 
     * <pre>
     * 示例 ： （假设上传文件后缀名为png）
     * <li>filePathParts为： {"platform", "sample"}， fileName为： headPortrait， 则文件路径为： platform/sample/headPortrait.png</li>
     * <li>filePathParts为： {"platform", "sample"}， fileName为： headPortrait.png， 则文件路径为： platform/sample/headPortrait.png</li>
     * </pre>
     * 
     * @param mpfile
     * @param rootDir
     *            保存上传文件的根目录或保存上传图片的根目录
     * @param filePathParts
     *            保存文件的目录名，可以指定任意多个，也可以不指定
     * @param fileName
     *            指定的新文件名（不需要包含后缀名）
     * @return 上传文件的保存路径（相对根目录的相对路径）
     */
    private static String getRelativeFilePath(MultipartFile mpfile, String[] filePathParts, String fileName) {
        if (UPLOAD_ROOT_PATH == null) {
            throw new ServiceRuntimeException("没有配置正确的上传文件根目录，无法支持文件的上传和下载功能！");
        }

        // 如果指定文件名中没有指定后缀名，则使用上传文件的后缀名
        if (fileName.indexOf(".") < 0) {
            String oriFilename = mpfile.getOriginalFilename();
            if (oriFilename.indexOf(".") > -1) {
                String suffix = oriFilename.substring(oriFilename.lastIndexOf("."));
                fileName = fileName + suffix;
            }
        }

        StringBuilder relativeFilePath = new StringBuilder(WEB_PATH_SEPARATOR);
        if (filePathParts != null) {
            for (String filePathPart : filePathParts) {
                relativeFilePath.append(filePathPart).append(WEB_PATH_SEPARATOR);
            }
        }
        relativeFilePath.append(fileName);
        return relativeFilePath.toString();
    }

    /**
     * 将上传文件从临时目录移动到正式目录并返回文件在正式目录下的相对路径
     * 
     * @param mpfile
     * @param rootDir
     * @param filePathParts
     * @param fileName
     * @return
     * @throws IOException
     */
    private static String transfer(MultipartFile mpfile, String[] filePathParts, String fileName) throws IOException {
        String relativeFilePath = getRelativeFilePath(mpfile, filePathParts, fileName);
        String fullFilePath = getFullFilePath(relativeFilePath);

        File newFile = new File(fullFilePath);
        if (newFile.exists()) {
            newFile.deleteOnExit();
        }

        File dirFile = newFile.getParentFile();
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        // 将文件从临时路径移动到保存上传文件的正式路径
        mpfile.transferTo(newFile);

        return relativeFilePath;
    }
}