package cn.sosopd.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sosopd.platform.entity.SosopdThirdPlatformAccount;
import cn.sosopd.platform.entity.SosopdThirdPlatformAccountExtend;

public interface SosopdThirdPlatformAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SosopdThirdPlatformAccount record);

    int insertSelective(SosopdThirdPlatformAccount record);

    SosopdThirdPlatformAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SosopdThirdPlatformAccount record);

    int updateByPrimaryKey(SosopdThirdPlatformAccount record);

    List<SosopdThirdPlatformAccountExtend> selectUserThirdPlarformAccount(@Param("userId") Integer userId,
            @Param("accountIds") Integer... accountIds);
}