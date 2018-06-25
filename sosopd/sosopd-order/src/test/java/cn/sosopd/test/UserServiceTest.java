package cn.sosopd.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.user.param.UserDto;
import cn.sosopd.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-all.xml" })
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testQueryUser() {
		try {
			System.out.println(JSON.toJSONString(userService.queryUserById(2), true));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveUser() {
		int userId = 2;
		UserDto user = new UserDto();
		user.setUserName("管理员3").setUserPhone("18672702153").setUserQq("9273092550").setUserEmail("9273092550@qq.com")
				.setCompanyName("test");
		try {
			userService.updateUserInfo(userId, user);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
