package cn.sosopd.common.helper;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * 文件下载管理器
 * 
 * @author ChenFeng
 * @date 2017年4月20日
 */
public abstract class DownloadHelper {

    private static Logger log = Logger.getLogger(DownloadHelper.class);

    /**
     * 下载文件
     * 
     * @param relativeFilePath
     *            文件的相对路径， UploadManager的transferFile或saveFile方法的返回值即为文件的相对路径
     * @param downloadFileName
     *            下载文件的别名，如果指定则下载文件使用这个名字，如果不指定则使用上传文件原来的文件名
     * @param request
     * @return
     */
    public static ResponseEntity<byte[]> downloadFile(String relativeFilePath, String downloadFileName,
            HttpServletRequest request) {
        if (StringUtils.isEmpty(relativeFilePath)) {
            throw new RuntimeException("下载文件相对路径不能为空");
        }

        String fullFilePath = UploadHelper.getFullFilePath(relativeFilePath);

        File file = new File(fullFilePath);

        return downloadFile(file, downloadFileName, request);
    }

    /**
     * 下载文件
     * 
     * @param file
     *            要下载的文件
     * @param downloadFileName
     *            下载文件的别名，如果指定则下载文件使用这个名字，如果不指定则使用上传文件原来的文件名
     * @param request
     * @return
     */
    public static ResponseEntity<byte[]> downloadFile(File file, String downloadFileName, HttpServletRequest request) {
        if (file == null) {
            log.warn("必须指定要下载的文件");
            throw new RuntimeException("必须指定要下载的文件");
        }
        if (!file.exists()) {
            log.warn("找不到文件：" + file.getPath());
            throw new RuntimeException("找不到文件：" + file.getPath());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        // 下载文件的文件名
        String filename;
        if (StringUtils.isNotBlank(downloadFileName)) {
            filename = downloadFileName;
        } else {
            filename = file.getName();
        }
        // 处理文件名中文乱码问题，参照帖子：lj830723.iteye.com/blog/1415479
        try {
            // 防止IE，chrome和火狐浏览器有乱码
            if (request.getHeader("user-agent").indexOf("MSIE") != -1) {
                filename = java.net.URLEncoder.encode(filename, "utf-8");
            } else {
                filename = new String(filename.getBytes("utf-8"), "iso-8859-1");
            }
        } catch (UnsupportedEncodingException e) {
            log.warn("处理文件名中文乱码问题时出错，文件名：" + filename);
        }
        headers.setContentDispositionFormData("attachment", filename);

        byte[] fileByteArray;
        try {
            fileByteArray = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            log.error("读取文件异常：" + file.getPath(), e);
            throw new RuntimeException("读取文件异常：" + file.getPath(), e);
        }

        System.out.println("Downloaded file : \n\t" + file.getPath());

        // 设置201(HttpStatus.CREATED)状态码时，使用IE下载时只能直接打开，不能保存，改成200(HttpStatus.OK)就可以了
        return new ResponseEntity<byte[]>(fileByteArray, headers, HttpStatus.OK);
    }

}