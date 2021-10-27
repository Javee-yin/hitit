package per.javee.hitit.module.unsafeDownload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/27 14:55
 * @Description:
 */
public interface UnsafeDownloadService {
    String upload(MultipartFile file);

    void downloadFile(String fileName);
}
