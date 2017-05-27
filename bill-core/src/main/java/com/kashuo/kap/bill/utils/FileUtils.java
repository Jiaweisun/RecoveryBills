package com.kashuo.kap.bill.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 文件操作帮助类
 *
 * @author 李伟伟
 * @create 2017/2/21
 */
public class FileUtils {

    /**
     * 保存文件
     *
     * @param file     文件对象
     * @param rootPath 文件根目录
     * @return
     */
    public static String saveFile(MultipartFile file, String rootPath) {
        String fileName = null;
        if (!file.isEmpty()) {
            InputStream inputStream = null;
            BufferedOutputStream outputStream = null;

            try {
                //定义上传路径
                if (!CustomStringUtils.isBlank(rootPath)) {
                    rootPath = rootPath.endsWith(File.separator) ? rootPath : rootPath + File.separator;
                    File rootFile = new File(rootPath);
                    if (!rootFile.exists()) {
                        rootFile.mkdirs();
                    }

                    fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                    String filePath = rootPath + fileName;
                    System.out.println("文件保存路径: " + filePath);
                    File localFile = new File(filePath);
                    outputStream = new BufferedOutputStream(new FileOutputStream(localFile));
                    inputStream = file.getInputStream();
                    byte[] mByte = new byte[1024];
                    while (inputStream.read(mByte) != -1) {
                        outputStream.write(mByte);
                    }
                    outputStream.flush();
                }
            } catch (Exception e) {
                fileName = null;
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
        return fileName;
    }
}
