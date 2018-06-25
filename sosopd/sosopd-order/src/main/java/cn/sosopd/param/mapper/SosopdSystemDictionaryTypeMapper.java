package cn.sosopd.param.mapper;

import cn.sosopd.param.entity.SosopdSystemDictionaryType;

public interface SosopdSystemDictionaryTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SosopdSystemDictionaryType record);

    int insertSelective(SosopdSystemDictionaryType record);

    SosopdSystemDictionaryType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SosopdSystemDictionaryType record);

    int updateByPrimaryKey(SosopdSystemDictionaryType record);
}