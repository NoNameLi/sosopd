package cn.sosopd.user.mapper;

import cn.sosopd.user.entity.SosopdUser;

public interface SosopdUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SosopdUser record);

    int insertSelective(SosopdUser record);

    SosopdUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SosopdUser record);

    int updateByPrimaryKey(SosopdUser record);

}
