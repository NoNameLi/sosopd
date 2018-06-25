package cn.sosopd.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sosopd.common.dto.Response;
import cn.sosopd.common.util.SysConstants;
import cn.sosopd.platform.entity.SosopdThirdPlatformExtend;
import cn.sosopd.platform.service.ThirdPlatformService;

@Controller
@RequestMapping(SysConstants.REQUEST_URL_PREFIX + "/thirdplatform")
public class ThirdPlatformContoller {

	@Autowired
	private ThirdPlatformService thirdPlatformService;

	@RequestMapping(value = "/getPresetPlatformByType.json", method = RequestMethod.GET)
	@ResponseBody
	public Response getPresetPlatformByType(String platformType) {

		List<SosopdThirdPlatformExtend> list = thirdPlatformService.queryPlatformByType(platformType);

		return new Response().success(list);
	}

	@RequestMapping(value = "/getPresetPlatform.json", method = RequestMethod.GET)
	@ResponseBody
	public Response getPresetPlatform() {
		return new Response().success(thirdPlatformService.getPlatform());
	}

}
