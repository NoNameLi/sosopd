package cn.sosopd.common.exception.extend;

import cn.sosopd.common.exception.ServiceException;

/**
 * 已处理的业务层共通检查异常
 * 
 * @author ChenFeng
 * @date 2016年4月23日
 */
public class FinalServiceException extends ServiceException {

    private static final long serialVersionUID = 7264728169882316339L;

    /**
     * 最终消息，可直接对最终用户展示，上层对异常进行封装时必须保留此消息
     */
    private String finalMessage;

    public FinalServiceException(String finalMessage) {
        super(finalMessage);
        this.finalMessage = finalMessage;
    }

    public FinalServiceException(String finalMessage, Throwable cause) {
        super(finalMessage, cause);
        this.finalMessage = finalMessage;
    }

    public String getFinalMessage() {
        return finalMessage;
    }

    public void setFinalMessage(String finalMessage) {
        this.finalMessage = finalMessage;
    }

}