package cn.sosopd.thirdPlatform.service;

import cn.sosopd.common.exception.ServiceException;

/**
 * 平台认证 登录 服务
 * 
 * @author remote
 *
 */
public interface PlatformAuthService {
    String loginCacheCookie(String account, String password) throws ServiceException;

    boolean isCookieOverdue(String cookie) throws ServiceException;
}
