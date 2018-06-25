package cn.sosopd.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sosopd.platform.entity.SosopdThirdPlatform;
import cn.sosopd.platform.entity.SosopdThirdPlatformExtend;
import cn.sosopd.platform.params.ThirdPlatformQueryParams;

public interface SosopdThirdPlatformMapper {
    int deleteByPrimaryKey(Integer platformId);

    int insert(SosopdThirdPlatform record);

    int insertSelective(SosopdThirdPlatform record);

    SosopdThirdPlatform selectByPrimaryKey(Integer platformId);

    int updateByPrimaryKeySelective(SosopdThirdPlatform record);

    int updateByPrimaryKey(SosopdThirdPlatform record);
    
    List<SosopdThirdPlatformExtend> selectByParams(@Param("params") ThirdPlatformQueryParams params);
}