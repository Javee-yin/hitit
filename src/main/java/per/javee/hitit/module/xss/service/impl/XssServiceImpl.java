package per.javee.hitit.module.xss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import per.javee.hitit.dbsupportor.entity.HMsg;
import per.javee.hitit.dbsupportor.entity.HMsgExample;
import per.javee.hitit.module.xss.dao.MsgUDMapper;
import per.javee.hitit.module.xss.entity.MsgVO;
import per.javee.hitit.module.xss.service.XssService;
import per.javee.hitit.utils.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: yinjw-b
 * @Date: 2021/11/2 10:38
 * @Description:
 */
@Service
public class XssServiceImpl implements XssService {

    @Autowired
    private MsgUDMapper msgUDMapper;

    @Override
    public void saveMsg(String name, String msg) {
        HMsg hMsg = new HMsg();
        hMsg.setId(HititIdUtil.getUniqueId());
        hMsg.setName(name);
        hMsg.setMsg(msg);
        hMsg.setCreatedBy(name);
        hMsg.setCreateTime(new Date());
        hMsg.setIsDeleted(0);
        msgUDMapper.insertSelective(hMsg);
    }

    @Override
    public List<MsgVO> getMsg() {
        HMsgExample example = new HMsgExample();
        example.createCriteria().andIsDeletedEqualTo(0);
        List<HMsg> hMsgs = msgUDMapper.selectByExample(example);
        List<MsgVO> msgVOS = ObjectCloneUtil.cloneList(hMsgs, MsgVO.class);
        return msgVOS;
    }
}
