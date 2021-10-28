package per.javee.hitit.module.forceBrute.service;

import per.javee.hitit.dbsupportor.entity.HUser;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/28 16:24
 * @Description:
 */
public interface ForceBruteService {
    HUser login(String name, String passwd);
}
