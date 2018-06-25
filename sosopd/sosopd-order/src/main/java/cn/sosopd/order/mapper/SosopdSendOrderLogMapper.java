package cn.sosopd.order.mapper;

import cn.sosopd.order.entity.SosopdSendOrderLog;

public interface SosopdSendOrderLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SosopdSendOrderLog record);

    int insertSelective(SosopdSendOrderLog record);

    SosopdSendOrderLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SosopdSendOrderLog record);

    int updateByPrimaryKey(SosopdSendOrderLog record);
}