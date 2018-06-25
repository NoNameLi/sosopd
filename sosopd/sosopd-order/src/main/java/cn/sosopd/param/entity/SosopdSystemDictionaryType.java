package cn.sosopd.param.entity;

import lombok.Data;

@Data
public class SosopdSystemDictionaryType {
    /**
     * 字典数据类型id
     */
    private Integer id;

    /**
     * 字典数据类型
     */
    private String typeKey;

    /**
     * 类型的表述
     */
    private String desc;

   
}