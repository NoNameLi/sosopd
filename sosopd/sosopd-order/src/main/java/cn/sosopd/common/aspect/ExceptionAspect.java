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
import cn.sosopd.common.util.SysConstants;

/**
 * Title: 全局异常处理切面 Description: 利用 @ControllerAdvice + @ExceptionHandler
 * 组合处理Controller层RuntimeException异常
 */
@ControllerAdvice // 控制器增强
public class ExceptionAspect {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

	@ResponseBody
	@ExceptionHandler(ServiceException.class)
	public Response handleFinalException(Exception e) {
		logger.error("请求异常", e.getMessage());
		return new Response().failure(e.getMessage());
	}
	
	@ExceptionHandler(AJAXTokenException.class)
	@ResponseBody
	public Response handleAJAXTokenException(Exception e) {
		logger.error("token is invalid", e.getMessage());
		return new Response().success(SysConstants.REQUEST_URL_PREFIX + "/login.html");
	}
	
	@ExceptionHandler(HtmlTokenException.class)
	public String handleHtmlTokenException(Exception e) {
		logger.error("token is invalid", e.getMessage());
		return "redirect:/" + SysConstants.REQUEST_URL_PREFIX + "/login.html";
	}
	

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public Response handleException(Exception e) {
		logger.error("请求异常", e);
		return new Response().failure("系统异常");
	}
}
