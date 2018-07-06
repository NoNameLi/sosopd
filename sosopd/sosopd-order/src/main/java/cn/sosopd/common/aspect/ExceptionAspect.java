package cn.sosopd.common.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.sosopd.common.dto.Response;
import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.common.exception.extend.AJAXTokenException;
import cn.sosopd.common.exception.extend.HtmlTokenException;
import cn.sosopd.common.util.SysConsts;
import cn.sosopd.constant.SpringMVCConsts;

/**
 * Title: 全局异常处理切面 Description: 利用 @ControllerAdvice + @ExceptionHandler
 * 组合处理Controller层RuntimeException异常
 */
@ControllerAdvice // 控制器增强
public class ExceptionAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    private static final String LOG_ERROR_KEY = "系统异常";

    private static final String ERROR_MESSAGE = "系统异常";

    private static final String LOG_TOKEN_KEY = "token is invalid";

    private static final String TOKEN_INVALID_TO_PATH = "/login.html";

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public Response handleFinalException(Exception e) {
        logger.error(LOG_ERROR_KEY, e.getMessage());
        return new Response().failure(e.getMessage());
    }

    @ExceptionHandler(AJAXTokenException.class)
    @ResponseBody
    public Response handleAJAXTokenException(Exception e) {
        logger.error(LOG_TOKEN_KEY, e.getMessage());
        return new Response().success(SysConsts.REQUEST_URL_PREFIX + TOKEN_INVALID_TO_PATH);
    }

    @ExceptionHandler(HtmlTokenException.class)
    public String handleHtmlTokenException(Exception e) {
        logger.error(LOG_TOKEN_KEY, e.getMessage());
        return SpringMVCConsts.REDIRECT_PATH_PREFIX + SysConsts.REQUEST_URL_PREFIX + TOKEN_INVALID_TO_PATH;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        logger.error(LOG_ERROR_KEY, e);
        return new Response().failure(ERROR_MESSAGE);
    }
}
