package cn.sosopd.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.sosopd.common.helper.DownloadHelper;

/**
 * 文件下载共通控制器
 * 
 * @author ChenFeng
 * @date 2016年3月11日
 */
@Controller
@RequestMapping("/common/download")
public class DownloadController {

    /**
     * 公共文件下载方法
     *
     * @param relativeFilePath
     *            文件的相对路径， UploadManager的transferFile或saveFile方法的返回值即为文件的相对路径
     * @param downloadFileName
     *            下载文件的别名，如果指定则下载文件使用这个名字，如果不指定则使用上传文件原来的文件名
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadAttachment(@RequestParam("filepath") String relativeFilePath,
            @RequestParam(value = "filename", required = false) String downloadFileName, HttpServletRequest request) {
        return DownloadHelper.downloadFile(relativeFilePath, downloadFileName, request);
    }

}