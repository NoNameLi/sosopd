package cn.sosopd.user.param;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class CreateAccountParams {

	/**
	 * 登录账号
	 */
	@NotEmpty(message = "账号或密码不能为空")
	private String account;

	/**
	 * 登录密码
	 */
	@NotEmpty(message = "账号或密码不能为空")
	private String password;

}
