package cn.sosopd.user.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class SosopdUser {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户姓名
     */
    @NotEmpty(message ="用户名不能为空")
    private String userName;

    /**
     * 用户电话
     */
    @NotEmpty(message="用户电话不能为空")
    private String userPhone;

    /**
     * 用户QQ
     */
    private String userQq;

    /**
     * 用户EMAIL
     */
    private String userEmail;

    /**
     * 
     */
    private String companyName;

    /**
     * 创建时间
     */
    private Date createDatetime;

    /**
     * 更新时间
     */
    private Date updateDatetime;

}