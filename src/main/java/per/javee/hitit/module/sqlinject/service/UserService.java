package per.javee.hitit.module.sqlinject.service;

import per.javee.hitit.dbsupportor.entity.HUser;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/19 15:16
 * @Description:
 */
public interface UserService {
    HUser getUserByName(String name);

    HUser getUserById(String id);

    HUser getUserPractice(String name);
}
