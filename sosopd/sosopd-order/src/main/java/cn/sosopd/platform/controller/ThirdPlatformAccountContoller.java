package cn.sosopd.platform.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.sosopd.common.dto.Response;
import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.common.util.SysConstants;
import cn.sosopd.common.util.UserTokenLocal;
import cn.sosopd.platform.entity.SosopdThirdPlatformAccountExtend;
import cn.sosopd.platform.params.ThirdPlatformCreateParams;
import cn.sosopd.platform.service.ThirdPlatformAccountService;

@Controller
@RequestMapping(SysConstants.REQUEST_URL_PREFIX + "/thirdplatformAccount")
public class ThirdPlatformAccountContoller {

	@Autowired
	private ThirdPlatformAccountService thirdPlatformAccountService;

	@RequestMapping("/getUserPlatformAccount.json")
	@ResponseBody
	public Response getUserPlatformAccount() throws ServiceException {

		List<SosopdThirdPlatformAccountExtend> list = thirdPlatformAccountService
				.listUserPlatformAccount(UserTokenLocal.getCurrentUser());

		return new Response().success(list);
	}

	@RequestMapping("/createPlatformAccount.json")
	@ResponseBody
	public Response createUserPlatformAccount(ThirdPlatformCreateParams params) throws ServiceException {

		thirdPlatformAccountService.saveUserThirdPlatformAccount(UserTokenLocal.getCurrentUser(), params);
		return new Response().success();
	}

}
