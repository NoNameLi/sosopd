package cn.sosopd.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.platform.entity.SosopdThirdPlatformExtend;
import cn.sosopd.platform.params.ThirdPlatformCreateParams;
import cn.sosopd.platform.params.ThirdPlatformQueryParams;
import cn.sosopd.platform.service.ThirdPlatformAccountService;
import cn.sosopd.platform.service.ThirdPlatformService;
import cn.sosopd.platform.type.PlatformPresetEnum;
import cn.sosopd.user.entity.SosopdUser;

/**
 * 第三方平台 和账号服务测试
 * 
 * @author remote
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-all.xml" })
public class ThirdPlatfromTest {

	@Autowired
	private ThirdPlatformService thirdPlatformService;

	@Autowired
	private ThirdPlatformAccountService thirdPlatformAccountService;

	@Test
	public void testPresetPlatform() {
		ThirdPlatformQueryParams params = ThirdPlatformQueryParams.builder().presetStatus(PlatformPresetEnum.SHOW.key)
				.build();
		List<SosopdThirdPlatformExtend> list = thirdPlatformService.listPlatformByParams(params);
		System.out.println(JSON.toJSONString(list, true));
	}

	@Test
	public void testlistByType() {
		try {
			System.out
					.println(JSON.toJSONString(thirdPlatformService.listPlatformByType("household_electrical"), true));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testlistPlatformAccount() {

		SosopdUser operator = new SosopdUser().setUserId(2);
		try {
			System.out.println(JSON.toJSONString(thirdPlatformAccountService.listUserPlatformAccount(operator), true));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddUserPlatformAccount() {
		SosopdUser operator = new SosopdUser().setUserId(2);
		ThirdPlatformCreateParams platformAccount = new ThirdPlatformCreateParams().setAccount("xxxxxxx")
				.setPassword("yyyyyy").setPlatformId(1);
		try {

			System.out.println(JSON.toJSONString(
					thirdPlatformAccountService.saveUserThirdPlatformAccount(operator, platformAccount), true));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
