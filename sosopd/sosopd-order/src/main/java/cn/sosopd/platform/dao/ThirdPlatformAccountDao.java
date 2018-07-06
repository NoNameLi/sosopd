package cn.sosopd.platform.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.platform.entity.SosopdThirdPlatformAccount;
import cn.sosopd.platform.entity.SosopdThirdPlatformAccountExtend;
import cn.sosopd.platform.mapper.SosopdThirdPlatformAccountMapper;
import cn.sosopd.platform.params.ThirdPlatformCreateParams;

@Component
public class ThirdPlatformAccountDao {

    @Autowired
    private SosopdThirdPlatformAccountMapper mapper;

    public List<SosopdThirdPlatformAccountExtend> listUserPlatformAccount(Integer userId, Integer... platformAccountIds)
            throws ServiceException {
        return mapper.selectUserThirdPlarformAccount(userId, platformAccountIds);
    }

    public int saveUserThirdPlatformAccount(Integer userId, ThirdPlatformCreateParams platformAccount) {

        SosopdThirdPlatformAccount account = new SosopdThirdPlatformAccount();
        BeanUtils.copyProperties(platformAccount, account);
        account.setUserId(userId);
        account.setStatus("reviewing");
        account.setCreateDatetime(new Date());
        return mapper.insertSelective(account);
    }
}
