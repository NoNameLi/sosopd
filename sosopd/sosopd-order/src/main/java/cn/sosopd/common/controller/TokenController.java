package cn.sosopd.common.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sosopd.common.anno.IgnoreSecurity;
import cn.sosopd.common.dto.Response;
import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.common.helper.UserTokenManager;
import cn.sosopd.common.util.SysConsts;
import cn.sosopd.common.util.UserTokenLocal;
import cn.sosopd.user.entity.SosopdUser;
import cn.sosopd.user.entity.SosopdUserAuth;
import cn.sosopd.user.service.UserAuthService;
import cn.sosopd.user.service.UserService;

/**
 * 用户登录
 * 
 * @author remote
 */

@Controller
public class TokenController {

    private static final Logger log = LoggerFactory.getLogger(TokenController.class);

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTokenManager userTokenManager;

    @RequestMapping(value = "/")
    public String root(HttpSession session) {
        return "redirect:index.html";
    }

    @RequestMapping(value = SysConsts.REQUEST_URL_PREFIX + "/login.json", method = RequestMethod.POST)
    @IgnoreSecurity
    @ResponseBody
    public Response login(@RequestParam("account") String uname, @RequestParam("password") String passwd,
            HttpServletResponse response) {
        if (userAuthService.checkAccount(uname, passwd) != null) {
            String token = userTokenManager.createToken(uname);
            log.info("**** Generate Token **** : " + token);
            Cookie cookie = new Cookie(SysConsts.DEFAULT_TOKEN_NAME, token);
            cookie.setPath("/");
            log.info("Write Token to Cookie and return to the Client : " + cookie.toString());
            response.addCookie(cookie);
            return new Response().success("index.html");
        }
        return new Response().failure("账号或密码错误");
    }

    @RequestMapping(value = SysConsts.REQUEST_URL_PREFIX + "/login2.json", method = RequestMethod.POST)
    @IgnoreSecurity
    @ResponseBody
    public Response login2(@RequestParam("account") String uname, @RequestParam("password") String passwd,
            HttpServletRequest request) throws ServiceException {
        SosopdUserAuth loginAccount = userAuthService.checkAccount(uname, passwd);
        if (loginAccount != null) {
            SosopdUser user = userService.getUserById(loginAccount.getUserId());
            request.getSession().setAttribute(SysConsts.DEFAULT_USER_SESSION_NAME, user);
            UserTokenLocal.setUser(user);
            return new Response().success("index.html");
        }
        return new Response().failure("账号或密码错误");
    }

    @RequestMapping(value = SysConsts.REQUEST_URL_PREFIX + "/quit.json", method = RequestMethod.POST)
    @ResponseBody
    public Response quit(HttpServletRequest request) {

        request.getSession().removeAttribute(SysConsts.DEFAULT_USER_SESSION_NAME);

        return new Response().success("退出成功");
    }
}
