package per.javee.hitit.module.sqlinject.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.javee.hitit.dbsupportor.entity.HUser;
import per.javee.hitit.dbsupportor.entity.HUserExample;
import per.javee.hitit.module.sqlinject.dao.UserUDMapper;
import per.javee.hitit.module.sqlinject.service.UserService;
import per.javee.hitit.utils.HititListUtils;
import per.javee.hitit.utils.HititObjectUtils;

import java.util.List;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/19 15:16
 * @Description:
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserUDMapper userMapper;

    @Override
    public HUser getUserByName(String name) {
        List<HUser> hUsers;
        name = "'" + name + "'";
        try {
            hUsers = userMapper.findUserByName(name);
        } catch (Exception e) {
            return new HUser();
        }
        if(HititListUtils.isEmptyList(hUsers)) return new HUser();
        return hUsers.get(0);
    }

    @Override
    public HUser getUserById(String id) {
        HUser user;
        try {
            user = userMapper.findUserById(id);
        } catch (Exception e) {
            return new HUser();
        }
        if(HititObjectUtils.isEmpty(user)) return new HUser();
        return user;
    }

    @Override
    public HUser getUserPractice(String name) {
        if(name.contains("'") || name.contains(" ") || name.contains("#") || name.contains("--")){
            log.info("系统检测到被攻击！已启动安全防护！！！");
            HUser hUser = new HUser();
            hUser.setName("Don't try hack me");
            hUser.setPhone("U R a loser");
            hUser.setAddress("Try another method");
            hUser.setSex("Fighting");
            return hUser;
        }
        HUserExample example = new HUserExample();
        // isdeleted = 0 为未被删除，=1为易删除，整个项目只使用逻辑删除
        example.createCriteria().andIsDeletedEqualTo(0)
                .andNameLike("%" + name + "%");
        List<HUser> hUsers;
        hUsers = userMapper.selectByExample(example);
        if(HititListUtils.isEmptyList(hUsers)) return new HUser();
        return hUsers.get(0);
    }
}
