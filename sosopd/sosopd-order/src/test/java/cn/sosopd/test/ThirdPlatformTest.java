package cn.sosopd.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.platform.dao.ThirdPlatformAccountDao;
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
public class ThirdPlatformTest {

    @Autowired
    private ThirdPlatformService thirdPlatformService;

    @Autowired
    private ThirdPlatformAccountService thirdPlatformAccountService;

    @Autowired
    private ThirdPlatformAccountDao thirdPlatformAccountDao;

    @Test
    public void testDaoList() {
        try {

            System.out
                    .println(Json.toJson(thirdPlatformAccountDao.listUserPlatformAccount(2, 1, 2), JsonFormat.nice()));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

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
            System.out.println(
                    JSON.toJSONString(thirdPlatformAccountService.listUserPlatformAccount(operator).size(), true));
            System.out.println(
                    JSON.toJSONString(thirdPlatformAccountService.listUserPlatformAccount(operator, 1, 2, 3), true));
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
