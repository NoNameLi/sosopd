package cn.sosopd.common.exception.extend;

import cn.sosopd.common.exception.ServiceRuntimeException;

/**
 * Title: 自定义的RuntimeException
 * Description:Token过期时抛出
 * @author rico
 * @created 2017年7月4日 下午4:56:44
 */
public class AJAXTokenException extends ServiceRuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String msg;

	public AJAXTokenException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
