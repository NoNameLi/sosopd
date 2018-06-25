package cn.sosopd.user.entity;

import java.util.Date;

import lombok.Data;

@Data
public class SosopdUserAuth {
    /**
     * 登录账号ID
     */
    private Integer id;
    
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 账号状态（0 不可使用 1 可以登录）
     */
    private String accountStatus;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createDatetime;

    /**
     * 更新时间
     */
    private Date updateDatetime;

    /**
     * 登录时间
     */
    private Date loginDatetime;

}