package cn.sosopd.user.param;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto implements Serializable {
    private static final long serialVersionUID = 5458176672167924003L;

    /**
     * 用户姓名
     */
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    /**
     * 用户电话
     */
    @NotEmpty(message = "用户电话不能为空")
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

}
