package per.javee.hitit.module.xss.service;

import per.javee.hitit.dbsupportor.entity.HMsg;
import per.javee.hitit.module.xss.entity.MsgVO;

import java.util.List;

/**
 * @Author: yinjw-b
 * @Date: 2021/11/2 10:38
 * @Description:
 */
public interface XssService {
    void saveMsg(String name, String msg);

    List<MsgVO> getMsg();
}
