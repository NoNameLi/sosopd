package cn.sosopd.platform.mapper;

import java.util.List;

import cn.sosopd.platform.entity.SosopdThirdPlatformAccount;
import cn.sosopd.platform.entity.SosopdThirdPlatformAccountExtend;

public interface SosopdThirdPlatformAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SosopdThirdPlatformAccount record);

    int insertSelective(SosopdThirdPlatformAccount record);

    SosopdThirdPlatformAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SosopdThirdPlatformAccount record);

    int updateByPrimaryKey(SosopdThirdPlatformAccount record);

    List<SosopdThirdPlatformAccountExtend> selectUserThirdPlarformAccount(int userId);
}