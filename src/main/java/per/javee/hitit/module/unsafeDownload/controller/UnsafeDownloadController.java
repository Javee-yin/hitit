package per.javee.hitit.module.unsafeDownload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import per.javee.hitit.common.entity.StringReturnData;
import per.javee.hitit.common.method.ResponseData;
import per.javee.hitit.module.unsafeDownload.service.UnsafeDownloadService;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/27 14:52
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/unsafeDownload")
public class UnsafeDownloadController {

    @Autowired
    private UnsafeDownloadService unsafeDownloadService;

    @PostMapping("/upload")
    public ResponseData upload(MultipartFile file){
        return ResponseData.instance(200, "查询成功", StringReturnData.instance(unsafeDownloadService.upload(file)));
    }

    @GetMapping("/downloadFile")
    public void downloadFile(String fileName){
        unsafeDownloadService.downloadFile(fileName);
    }

}
