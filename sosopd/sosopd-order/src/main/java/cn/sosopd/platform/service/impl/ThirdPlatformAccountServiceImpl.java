package cn.sosopd.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.common.validator.ParamValidator;
import cn.sosopd.platform.dao.ThirdPlatformAccountDao;
import cn.sosopd.platform.entity.SosopdThirdPlatformAccountExtend;
import cn.sosopd.platform.params.ThirdPlatformCreateParams;
import cn.sosopd.platform.service.ThirdPlatformAccountService;
import cn.sosopd.user.entity.SosopdUser;

@Service
public class ThirdPlatformAccountServiceImpl implements ThirdPlatformAccountService {

    @Autowired
    private ThirdPlatformAccountDao thirdPlatformAccountDao;

    @Override
    public List<SosopdThirdPlatformAccountExtend> listUserPlatformAccount(SosopdUser operator,
            Integer... platformAccountIds) throws ServiceException {
        ParamValidator.assertNotNull(operator, "用户不能为空");

        return thirdPlatformAccountDao.listUserPlatformAccount(operator.getUserId(), platformAccountIds);
    }

    @Override
    public int saveUserThirdPlatformAccount(SosopdUser operator, ThirdPlatformCreateParams platformAccount)
            throws ServiceException {
        ParamValidator.assertNotNull(operator, "用户不能为空");
        ParamValidator.assertNotNull(platformAccount, "平台账号不能为空");
        
        return thirdPlatformAccountDao.saveUserThirdPlatformAccount(operator.getUserId(), platformAccount);
    }
}
