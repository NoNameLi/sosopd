package cn.sosopd.common.exception;

/**
 * 业务层公共通运行时异常
 * 
 * @author ChenFeng
 * @date 2014/10/22
 */
public class ServiceRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 3583566093089790852L;

	public ServiceRuntimeException() {
		super();
	}

	public ServiceRuntimeException(String message) {
		super(message);
	}

	public ServiceRuntimeException(Throwable cause) {
		super(cause);
	}

	public ServiceRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
}