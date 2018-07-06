package cn.sosopd.user.mapper;

import org.apache.ibatis.annotations.Param;

import cn.sosopd.user.entity.SosopdUser;
import cn.sosopd.user.entity.SosopdUserAuth;

public interface SosopdUserAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SosopdUserAuth record);

    int insertSelective(SosopdUserAuth record);

    SosopdUserAuth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SosopdUserAuth record);

    int updateByPrimaryKey(SosopdUserAuth record);

    SosopdUserAuth selectAccountByAccAPass(@Param("account") String account, @Param("password") String password);

    Boolean ishasAccount(@Param("account") String account);

    SosopdUser selectUserByAccount(@Param("account") String account, @Param("password") String password);

}