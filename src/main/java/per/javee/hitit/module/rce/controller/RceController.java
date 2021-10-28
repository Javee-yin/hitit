package per.javee.hitit.module.rce.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.javee.hitit.common.entity.StringReturnData;
import per.javee.hitit.module.rce.service.RceService;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/28 10:38
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/rce")
public class RceController {

    @Autowired
    private RceService rceService;

    @GetMapping("/exec")
    public StringReturnData exec(String command){
        return StringReturnData.instance(rceService.exec(command));
    }
}
