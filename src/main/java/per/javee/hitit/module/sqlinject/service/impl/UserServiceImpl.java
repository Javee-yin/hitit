package per.javee.hitit.module.sqlinject.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.javee.hitit.dbsupportor.entity.HUser;
import per.javee.hitit.dbsupportor.entity.HUserExample;
import per.javee.hitit.dbsupportor.mapper.HUserMapper;
import per.javee.hitit.module.sqlinject.dao.UserUDMapper;
import per.javee.hitit.module.sqlinject.service.UserService;
import per.javee.hitit.utils.HititListUtils;

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
        try {
            hUsers = userMapper.findUserByName(name);
        } catch (Exception e) {
            return new HUser();
        }
        if(HititListUtils.isEmptyList(hUsers)) return new HUser();
        return hUsers.get(0);
    }
}
