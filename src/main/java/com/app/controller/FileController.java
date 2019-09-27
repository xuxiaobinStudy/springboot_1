package com.app.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @Description 文件操作类
 * @Author acer
 * @Date 2019/9/21 21:01
 **/
@Controller
public class FileController {

    private Logger log = LoggerFactory.getLogger(FileController.class);

    @ResponseBody
    @RequestMapping("/file/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        // 获取原始名字，包括后缀名
        String fileName = file.getOriginalFilename();
        // 获取后缀名
        // String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件保存路径
        String filePath = "D:/tools/showToLinux/";
        // 文件重命名，防止重复
        fileName = filePath + UUID.randomUUID() + fileName;
        // 文件对象
        File distFile = new File(fileName);
        // 判断路径是否存在，如果不存在则创建
        if (!distFile.getParentFile().exists()) {
            distFile.getParentFile().mkdirs();
        }
        try {
            // 保存到服务器中
            file.transferTo(distFile);
            return "上传成功";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "上传失败";
    }

    @RequestMapping("/file/download")
    public void downLoadFile(HttpServletResponse response) {
        FileInputStream fis = null;
        try {
            // 文件地址，真实环境是存放在数据库中的
            File file = new File("D:/tools/showToLinux/hello.txt");
            // 文件输入对象
            fis = new FileInputStream(file);
            // 设置为下载模式
            response.setContentType("application/x-download");
            // 设置下载后的文件名以及header
            response.addHeader("Content-disposition", "attachment;fileName=" + "测试文件");
            // 创建输出对象
            OutputStream os = response.getOutputStream();
            // 使用工具
            IOUtils.copy(fis, os);
            os.flush();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (null != fis) {
                    fis.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}