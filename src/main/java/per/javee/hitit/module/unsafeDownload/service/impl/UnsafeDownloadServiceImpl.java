package per.javee.hitit.module.unsafeDownload.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import per.javee.hitit.module.unsafeDownload.service.UnsafeDownloadService;
import per.javee.hitit.utils.HititDateUtil;
import per.javee.hitit.utils.HititIdUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/27 14:56
 * @Description:
 */
@Service
@Slf4j
public class UnsafeDownloadServiceImpl implements UnsafeDownloadService {

    @Value("${file.path}")
    private String basePath;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @Override
    public String upload(MultipartFile file) {

        if (file == null) {
            return null;
        }

        //将上传的文件存入本地
        String fileName = file.getOriginalFilename();
        String fileUniqueName = String.valueOf(HititIdUtil.getUniqueId());
        fileUniqueName += fileName.substring(fileName.lastIndexOf("."));
        String savePath = HititDateUtil.date2string(new Date(), "yyyyMM");
        String filePath = savePath + "/" + fileUniqueName;

        try {
            File baseDir = new File(basePath);
            if (!baseDir.exists()  && !baseDir.isDirectory()){
                baseDir.mkdir();
            }
            String datePath = basePath + "/" + savePath;
            File dateDir = new File(datePath);
            if (!dateDir.exists()  && !dateDir.isDirectory()){
                dateDir.mkdir();
            }
            File fileNew = new File(basePath + "/" + filePath);
            log.info("before transferTo");
            fileNew.createNewFile();
            file.transferTo(fileNew);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return filePath;
    }

    @Override
    public void downloadFile(String fileName) {
        ServletOutputStream outputStream = null;
        try {
            if (fileName == null) {
                return;
            }
            byte[] bytes = download(fileName);
            String[] nameSplit = fileName.split("/");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(nameSplit[nameSplit.length - 1], "UTF-8"));
            response.setCharacterEncoding("UTF-8");

            outputStream = response.getOutputStream();
            outputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private byte[] download(String fileUrl) throws Exception {
        File file = new File(basePath + "/" +fileUrl);
        if(!file.isFile() || !file.exists()){
            return new byte[0];
        }

        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length
                && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }
        // 确保所有数据均被读取
        if (offset != buffer.length) {
            throw new IOException("Could not completely read file "+ file.getName());
        }
        fi.close();
        return buffer;

    }


}
