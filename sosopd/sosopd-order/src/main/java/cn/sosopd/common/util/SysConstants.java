package cn.sosopd.common.util;

/**        
 * Title: 常量    
 * Description: 
 */      
public class SysConstants {

	/**
	 * 存储当前登录用户id的字段名
	 */
	public static final String CURRENT_USER_ID = "CURRENT_USER_ID";

	/**
	 * token有效期（小时）
	 */
	public static final int TOKEN_EXPIRES_HOUR = 72;

	/**  存放Token的header字段 */      
	public static final String DEFAULT_TOKEN_NAME = "X-Token";
	
	public static final String DEFAULT_USER_SESSION_NAME = "sessionuser";
	
	/**  ajax 请求中的头 */  
	public static final String DEFAULT_AJAX_HEAD_NAME = "X-Requested-with";
	/**  ajax 请求中的头 的值*/  
	public static final String DEFAULT_AJAC_HEAD_VALUE = "XMLHttpRequest";
	
	public static final String REQUEST_URL_PREFIX = "sosopd";

}
