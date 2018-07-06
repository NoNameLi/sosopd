package cn.sosopd.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.sosopd.common.util.SysConsts;
import cn.sosopd.common.util.UserTokenLocal;
import cn.sosopd.user.entity.SosopdUser;

/**
 * 系统级拦截器
 * 
 * @author ChenFeng <a>http://git.oschina.net/yunzhongzhu</a>
 * @date Jun 18, 2014
 */
public class SystemInterceptor extends HandlerInterceptorAdapter {

    /**
     * 进行请求的预处理， 然后根据返回值决定是否继续处理 （true： 继续过滤器链）； 可以通过它实现权限控制
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 从session中获取登录用户信息
        SosopdUser sosopdUser = (SosopdUser) request.getSession().getAttribute(SysConsts.DEFAULT_USER_SESSION_NAME);
        // 将登录用户信息设置到ThreadLocal中
        UserTokenLocal.setUser(sosopdUser);
        return true;
    }

    /**
     * 执行完拦截器链之后正常返回后执行
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // 从ThreadLocal中移除登录用户信息
    }

    /**
     * 不管最后有没有异常，afterCompletion都会执行，完成如清理资源功能
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 从ThreadLocal中移除登录用户信息
    }

}