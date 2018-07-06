package cn.sosopd.common.exception.extend;

import cn.sosopd.common.exception.ServiceException;

/**
 * 业务层参数校验异常
 * 
 * @author ChenFeng
 * @date 2016年8月9日
 */
public class ParamValidationException extends ServiceException {

    private static final long serialVersionUID = 908272095950629424L;

    private String parameterName;

    public ParamValidationException(String message) {
        super(message);
    }

    public ParamValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamValidationException(String message, String parameterName) {
        super(message);
        this.parameterName = parameterName;
    }

    public ParamValidationException(String message, String parameterName, Throwable cause) {
        super(message, cause);
        this.parameterName = parameterName;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

}