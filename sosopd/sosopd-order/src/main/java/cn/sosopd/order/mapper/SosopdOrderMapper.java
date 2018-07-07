package cn.sosopd.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sosopd.order.entity.SosopdOrder;
import cn.sosopd.order.entity.SosopdOrderExtend;
import cn.sosopd.order.params.QueryOrderParams;
import cn.sosopd.order.params.UpdateOrderCondition;

public interface SosopdOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(SosopdOrder record);

    int insertSelective(SosopdOrder record);

    SosopdOrder selectByPrimaryKey(@Param("userId") Integer userId, @Param("orderId") Integer orderId);

    List<SosopdOrder> selectByPrimaryKeys(@Param("userId") Integer userId, @Param("orderIds") Integer... orderIds);

    int updateByPrimaryKeySelective(SosopdOrder record);

    int updateByPrimaryKey(SosopdOrder record);

    int updateByRowLock(@Param("condition") UpdateOrderCondition condition, @Param("order") SosopdOrder record);

    int updateBatch(@Param("orders") List<SosopdOrder> orders);

    List<SosopdOrderExtend> queryOrderByParams(@Param("userId") Integer userId,
            @Param("params") QueryOrderParams params);

}