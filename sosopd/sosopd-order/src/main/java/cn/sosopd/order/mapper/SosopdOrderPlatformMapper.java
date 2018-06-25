package cn.sosopd.order.mapper;

import cn.sosopd.order.entity.SosopdOrderPlatform;

public interface SosopdOrderPlatformMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(SosopdOrderPlatform record);

    int insertSelective(SosopdOrderPlatform record);

    SosopdOrderPlatform selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(SosopdOrderPlatform record);

    int updateByPrimaryKey(SosopdOrderPlatform record);
}