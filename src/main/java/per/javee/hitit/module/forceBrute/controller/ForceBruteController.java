package per.javee.hitit.module.forceBrute.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.javee.hitit.dbsupportor.entity.HUser;
import per.javee.hitit.module.forceBrute.service.ForceBruteService;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/28 15:13
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/forceBrute")
public class ForceBruteController {

    @Autowired
    private ForceBruteService forceBruteService;

    @GetMapping("/login")
    public HUser login(String name, String passwd){
        return forceBruteService.login(name, passwd);
    }
}
