package cn.sosopd.order.mapper;

import cn.sosopd.order.entity.SosopdOrderAttached;

public interface SosopdOrderAttachedMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(SosopdOrderAttached record);

    int insertSelective(SosopdOrderAttached record);

    SosopdOrderAttached selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(SosopdOrderAttached record);

    int updateByPrimaryKey(SosopdOrderAttached record);
}