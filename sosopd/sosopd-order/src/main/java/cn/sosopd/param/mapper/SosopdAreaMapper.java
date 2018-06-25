package cn.sosopd.param.mapper;

import cn.sosopd.param.entity.SosopdArea;

public interface SosopdAreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SosopdArea record);

    int insertSelective(SosopdArea record);

    SosopdArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SosopdArea record);

    int updateByPrimaryKey(SosopdArea record);
}