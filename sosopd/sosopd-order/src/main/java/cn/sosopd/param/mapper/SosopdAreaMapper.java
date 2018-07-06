package cn.sosopd.param.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sosopd.param.entity.SosopdArea;
import cn.sosopd.param.entity.SosopdAreaExample;

public interface SosopdAreaMapper {

    int countByExample(SosopdAreaExample example);

    int deleteByExample(SosopdAreaExample example);

    int deleteByPrimaryKey(Short id);

    int insert(SosopdArea record);

    int insertSelective(SosopdArea record);

    List<SosopdArea> selectByParentId(Short parentId);

    List<SosopdArea> selectByExample(SosopdAreaExample example);

    SosopdArea selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") SosopdArea record, @Param("example") SosopdAreaExample example);

    int updateByExample(@Param("record") SosopdArea record, @Param("example") SosopdAreaExample example);

    int updateByPrimaryKeySelective(SosopdArea record);

    int updateByPrimaryKey(SosopdArea record);

}