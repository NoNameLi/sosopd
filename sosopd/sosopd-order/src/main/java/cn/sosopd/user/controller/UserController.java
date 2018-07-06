package cn.sosopd.user.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sosopd.common.anno.IgnoreSecurity;
import cn.sosopd.common.dto.Response;
import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.common.util.SysConsts;
import cn.sosopd.common.util.UserTokenLocal;
import cn.sosopd.common.validator.BeanValidator;
import cn.sosopd.user.entity.SosopdUser;
import cn.sosopd.user.entity.SosopdUserAuth;
import cn.sosopd.user.param.CreateAccountParams;
import cn.sosopd.user.param.UserDto;
import cn.sosopd.user.service.UserAuthService;
import cn.sosopd.user.service.UserService;

/**
 * 用户管理
 * 
 * @author remote
 */

@Controller
@RequestMapping(SysConsts.REQUEST_URL_PREFIX + "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthService userAuthService;

    @RequestMapping(value = "/createUser.json", method = RequestMethod.POST)
    @ResponseBody
    @IgnoreSecurity
    public Response createUser(CreateAccountParams data) throws ServiceException {
        BeanValidator.validate(data);
        SosopdUserAuth userAuth = new SosopdUserAuth();
        BeanUtils.copyProperties(data, userAuth);
        userAuthService.saveAccount(userAuth);
        return new Response().success("创建成功");
    }

    @RequestMapping(value = "/getUserInfo.json", method = RequestMethod.GET)
    @ResponseBody
    public Response getUserInfo() throws ServiceException {
        SosopdUser currentUser = UserTokenLocal.getCurrentUser();
        SosopdUser user;
        user = userService.getUserById(currentUser.getUserId());

        return new Response().success(user);
    }

    @RequestMapping(value = "/updateUserInfo.json", method = RequestMethod.POST)
    @ResponseBody
    public Response updateUserInfo(UserDto userInfo) {

        return new Response().success();
    }

}
