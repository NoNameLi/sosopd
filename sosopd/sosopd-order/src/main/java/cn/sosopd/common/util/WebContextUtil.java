package cn.sosopd.common.util;

import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.sosopd.user.entity.SosopdUser;

/**
 * Title: Web上下文工具类
 * 
 * @author rico
 * @created 2017年7月4日 下午5:16:42
 */
public class WebContextUtil {

    /**
     * @description 获取HTTP请求
     * @author rico
     * @created 2017年7月4日 下午5:18:08
     * @return
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request;
    }

    public static SosopdUser getUserSession() {
        return (SosopdUser) getRequest().getSession().getAttribute(SysConsts.DEFAULT_USER_SESSION_NAME);
    }

    public static String getCookieValue(String cookieName) {
        Cookie[] cookies = getRequest().getCookies();
        for (Cookie cookie : cookies) {
            if (Objects.equals(cookieName, cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
