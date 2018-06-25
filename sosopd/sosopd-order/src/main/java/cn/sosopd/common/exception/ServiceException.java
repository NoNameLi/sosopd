package cn.sosopd.common.exception;

/**
 * 业务层共通检查异常
 * 
 * @author ChenFeng
 * @date 2014/10/22
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 4560445649071723771L;

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}