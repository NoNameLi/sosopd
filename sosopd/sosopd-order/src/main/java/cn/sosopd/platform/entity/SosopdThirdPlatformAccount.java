package cn.sosopd.platform.entity;

import java.util.Date;

import lombok.Data;

@Data
public class SosopdThirdPlatformAccount {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private Integer platformId;

    /**
     * 
     */
    private String account;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private Date createDatetime;

    /**
     * 
     */
    private Date updateDatetime;

    /**
     * 
     */
    private Date deleteDatetime;

}