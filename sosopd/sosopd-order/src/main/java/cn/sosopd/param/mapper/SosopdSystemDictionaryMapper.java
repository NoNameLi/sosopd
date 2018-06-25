package cn.sosopd.param.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sosopd.param.entity.SosopdSystemDictionary;

public interface SosopdSystemDictionaryMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(SosopdSystemDictionary record);

	int insertSelective(SosopdSystemDictionary record);

	SosopdSystemDictionary selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SosopdSystemDictionary record);

	int updateByPrimaryKey(SosopdSystemDictionary record);

	List<SosopdSystemDictionary> selectByType(@Param("typeKey") String typeKey);
}