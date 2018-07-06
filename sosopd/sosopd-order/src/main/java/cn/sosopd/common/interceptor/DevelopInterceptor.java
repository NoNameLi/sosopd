package cn.sosopd.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.sosopd.constant.DelimiterConsts;

/**
 * 开发用拦截器
 * 
 * <pre>
 * <b>本框架对于请求URL后缀做如下约定：</b>
 * <li>1、页面请求统一以.html作为后缀</li>
 * <li>2、Ajax请求统一以.json作为后缀</li>
 * </pre>
 * 
 * @author ChenFeng <a>http://git.oschina.net/yunzhongzhu</a>
 * @date 2014/10/22
 */
public class DevelopInterceptor extends HandlerInterceptorAdapter {

    private static Logger LOGGER = Logger.getLogger(DevelopInterceptor.class);

    private static final String LOG_URL_KEY = "url" + DelimiterConsts.COLON;

    private static final String LOG_URL_ERROR_KEY = "可能使用了错误的请求URL，没有添加正确的后缀（如.html或者.json）：";

    /**
     * 进行请求的预处理， 然后根据返回值决定是否继续处理 （true： 继续过滤器链）； 可以通过它实现权限控制
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String uri = request.getRequestURI();
        LOGGER.warn(LOG_URL_KEY + uri);
        if (StringUtils.isNotEmpty(uri)) {
            String uriLast = StringUtils.substringAfterLast(uri, DelimiterConsts.SLASH);
            if (StringUtils.contains(uriLast, DelimiterConsts.SEMICOLON)) {
                uriLast = StringUtils.substringBefore(uriLast, DelimiterConsts.SEMICOLON);
            }
            if (StringUtils.isNotEmpty(uriLast) && !StringUtils.contains(uriLast, DelimiterConsts.SPOT)) {
                LOGGER.warn(LOG_URL_ERROR_KEY + uri);
            }
        }
        return true;
    }

    /**
     * 执行完拦截器链之后正常返回后执行
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    /**
     * 不管最后有没有异常，afterCompletion都会执行，完成如清理资源等功能
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}