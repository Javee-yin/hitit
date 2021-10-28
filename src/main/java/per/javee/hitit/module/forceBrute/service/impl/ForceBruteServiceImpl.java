package per.javee.hitit.module.forceBrute.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.javee.hitit.dbsupportor.entity.HUser;
import per.javee.hitit.dbsupportor.entity.HUserExample;
import per.javee.hitit.module.forceBrute.service.ForceBruteService;
import per.javee.hitit.dao.UserUDMapper;
import per.javee.hitit.utils.HititListUtils;
import per.javee.hitit.utils.UserPwdManager;

import java.util.List;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/28 16:25
 * @Description:
 */
@Service
@Slf4j
public class ForceBruteServiceImpl implements ForceBruteService {

    @Autowired
    private UserUDMapper userUDMapper;

    @Override
    public HUser login(String name, String passwd) {

        log.info("name:{}, password:{}", name, passwd);

        HUserExample example = new HUserExample();
        example.createCriteria().andNameEqualTo(name)
                .andIsDeletedEqualTo(0);
        List<HUser> hUsers = userUDMapper.selectByExample(example);

        if(HititListUtils.isEmptyList(hUsers) || !UserPwdManager.matches(passwd, hUsers.get(0).getPwd())) {
            HUser hUser = new HUser();
            hUser.setName("Error");
            hUser.setPhone("Username or password error");
            hUser.setAddress("Try again");
            hUser.setSex("Fighting");
            return hUser;
        }

        return hUsers.get(0);
    }
}
