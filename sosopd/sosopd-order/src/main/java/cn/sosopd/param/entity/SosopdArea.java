package cn.sosopd.param.entity;

import lombok.Data;

@Data
public class SosopdArea {
	 /**
     * 
     */
    private Short id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Short parentId;

    /**
     * 
     */
    private String initial;

    /**
     * 
     */
    private String initials;

    /**
     * 
     */
    private String pinyin;

    /**
     * 
     */
    private String suffix;

    /**
     * 
     */
    private String code;

    /**
     * 
     */
    private Byte order;

}