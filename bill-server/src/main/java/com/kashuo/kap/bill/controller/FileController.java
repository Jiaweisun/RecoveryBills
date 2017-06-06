package com.kashuo.kap.bill.controller;

import com.kashuo.kap.bill.utils.CustomStringUtils;
import com.kashuo.kap.bill.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by sunjiawei on 2017/5/27.
 */
@Controller
@RequestMapping(value = "/file")
public class FileController extends BaseController{

    private  String rootPath = "d:\\upload\\";
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public void upload(@RequestParam("fileName") MultipartFile file){
        log.info("文件开始。。。上传");
        FileUtils.saveFile(file,rootPath);

    }


    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response) {

        log.info("文件开始。。。");
        if (!CustomStringUtils.isBlank(rootPath) && !CustomStringUtils.isBlank(fileName)) {
            rootPath = rootPath.endsWith(File.separator) ? rootPath : rootPath + File.separator;
            String filePath = rootPath + fileName;

            File file = new File(filePath);
            BufferedInputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                //设置文件ContentType类型，这样设置，会自动判断下载文件类型
                response.setContentType("multipart/form-data");
                //设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
                response.addHeader("Content-Length", "" + file.length());

                inputStream = new BufferedInputStream(new FileInputStream(file));
                outputStream = response.getOutputStream();

                int b = 0;
                byte[] buffer = new byte[1024];

                while (b != -1) {
                    b = inputStream.read(buffer);
                    //4.写到输出流(out)中
                    outputStream.write(buffer, 0, b);
                }

                outputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
