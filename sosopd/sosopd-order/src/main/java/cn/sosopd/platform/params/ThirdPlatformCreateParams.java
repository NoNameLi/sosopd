package cn.sosopd.platform.params;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户创建平台账号数据对象
 * 
 * @author Administrator
 *
 */
@Data
@Accessors(chain = true)
public class ThirdPlatformCreateParams {

    @NotNull(message = "账号的所属平台不能为空")
    private Integer platformId;

    @NotEmpty(message = "账号密码不能为空")
    private String account;

    @NotEmpty(message = "账号密码不能为空")
    private String password;
}
