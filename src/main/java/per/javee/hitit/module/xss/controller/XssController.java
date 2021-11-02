package per.javee.hitit.module.xss.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.javee.hitit.common.method.ResponseData;
import per.javee.hitit.dbsupportor.entity.HMsg;
import per.javee.hitit.module.xss.entity.MsgVO;
import per.javee.hitit.module.xss.service.XssService;

import java.util.List;

/**
 * @Author: yinjw-b
 * @Date: 2021/11/2 10:36
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/xss")
public class XssController {

    @Autowired
    private XssService xssService;

    @GetMapping("/saveMsg")
    public ResponseData saveMsg(String name, String msg) {
        log.info("存储用户提交的留言信息：" + name + "--" + msg);
        xssService.saveMsg(name, msg);
        return ResponseData.instance(200, "保存成功");
    }

    @GetMapping("/getMsg")
    public List<MsgVO> getMsg() {
        log.info("获取用户提交的留言信息");
        return xssService.getMsg();
    }
}
