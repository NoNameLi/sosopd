package cn.sosopd.task.mapper;

import cn.sosopd.task.entity.SosopdTask;
import cn.sosopd.task.entity.SosopdTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SosopdTaskMapper {
	int countByExample(SosopdTaskExample example);

	int deleteByExample(SosopdTaskExample example);

	int deleteByPrimaryKey(Integer orderId);

	int insert(SosopdTask record);

	int insertSelective(SosopdTask record);

	int insertUpdate(SosopdTask record);

	List<SosopdTask> selectByExample(SosopdTaskExample example);

	SosopdTask selectByPrimaryKey(Integer orderId);

	int updateByExampleSelective(@Param("record") SosopdTask record, @Param("example") SosopdTaskExample example);

	int updateByExample(@Param("record") SosopdTask record, @Param("example") SosopdTaskExample example);

	int updateByPrimaryKeySelective(SosopdTask record);

	int updateByPrimaryKey(SosopdTask record);
}