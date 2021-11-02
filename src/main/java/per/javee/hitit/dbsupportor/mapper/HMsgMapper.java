package per.javee.hitit.dbsupportor.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import per.javee.hitit.dbsupportor.entity.HMsg;
import per.javee.hitit.dbsupportor.entity.HMsgExample;

public interface HMsgMapper {
    long countByExample(HMsgExample example);

    int deleteByExample(HMsgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HMsg record);

    int insertSelective(HMsg record);

    List<HMsg> selectByExample(HMsgExample example);

    HMsg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HMsg record, @Param("example") HMsgExample example);

    int updateByExample(@Param("record") HMsg record, @Param("example") HMsgExample example);

    int updateByPrimaryKeySelective(HMsg record);

    int updateByPrimaryKey(HMsg record);
}