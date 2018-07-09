package cn.sosopd.common.exception.extend;

import cn.sosopd.common.exception.ServiceException;

/**
 * 第三方对接时的异常
 * 
 * @author remote
 *
 */
public class NetworkException extends ServiceException {
    private static final long serialVersionUID = 7645395065549934054L;

    public NetworkException(String message) {
        super(message);
    }
    
    public NetworkException(String message, Throwable cause) {
        super(message, cause);
    }

}
