package per.javee.hitit.dbsupportor.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import per.javee.hitit.dbsupportor.entity.HUser;
import per.javee.hitit.dbsupportor.entity.HUserExample;

public interface HUserMapper {
    long countByExample(HUserExample example);

    int deleteByExample(HUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HUser record);

    int insertSelective(HUser record);

    List<HUser> selectByExample(HUserExample example);

    HUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HUser record, @Param("example") HUserExample example);

    int updateByExample(@Param("record") HUser record, @Param("example") HUserExample example);

    int updateByPrimaryKeySelective(HUser record);

    int updateByPrimaryKey(HUser record);
}