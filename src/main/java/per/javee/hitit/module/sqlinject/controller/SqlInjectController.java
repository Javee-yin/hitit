package per.javee.hitit.module.sqlinject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.javee.hitit.dbsupportor.entity.HUser;
import per.javee.hitit.module.sqlinject.service.UserService;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/19 15:13
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/sqlinject")
public class SqlInjectController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public HUser getUser(String name) {
        log.info("通过用户名获取用户信息：" + name);
        return userService.getUserByName(name);
    }

    @GetMapping("/getUserPractice")
    public HUser getUserPractice(String name) {
        log.info("通过用户名获取用户信息：" + name);
        return userService.getUserPractice(name);
    }

    @PostMapping("/getUserPractice")
    public HUser getUserPracticeInject(String name) {
        log.info("通过用户名获取用户信息：" + name);
        return userService.getUserByName(name);
    }

    @GetMapping("/getUserById")
    public HUser getUserById(String id) {
        log.info("通过id获取用户信息：" + id);
        return userService.getUserById(id);
    }

    @PostMapping("/getUserByIdPost")
    public HUser getUserByIdPost(String id) {
        log.info("通过id获取用户信息：" + id);
        return userService.getUserById(id);
    }
}
