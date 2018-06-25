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

	int updateByPrimaryKeySelective(SosopdOrder record);

	int updateByPrimaryKey(SosopdOrder record);

	List<SosopdOrderExtend> queryOrderByParams(@Param("userId") Integer userId,
			@Param("params") QueryOrderParams params);

	int updateByParams(@Param("condition") UpdateOrderCondition condition, @Param("order") SosopdOrder record);

}