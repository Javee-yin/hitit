package per.javee.hitit.module.sqlinject.dao;

import per.javee.hitit.dbsupportor.entity.HUser;
import per.javee.hitit.dbsupportor.mapper.HUserMapper;

import java.util.List;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/19 17:04
 * @Description:
 */
public interface UserUDMapper extends HUserMapper {
    List<HUser> findUserByName(String name);

    HUser findUserById(String id);
}
