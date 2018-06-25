package cn.sosopd.platform.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.common.validator.ParamValidator;
import cn.sosopd.platform.entity.SosopdThirdPlatformAccount;
import cn.sosopd.platform.entity.SosopdThirdPlatformAccountExtend;
import cn.sosopd.platform.mapper.SosopdThirdPlatformAccountMapper;
import cn.sosopd.platform.params.ThirdPlatformCreateParams;
import cn.sosopd.platform.service.ThirdPlatformAccountService;
import cn.sosopd.user.entity.SosopdUser;

@Service
public class ThirdPlatformAccountServiceImpl implements ThirdPlatformAccountService{
	
	@Autowired
	private SosopdThirdPlatformAccountMapper thirdPlatformAccountMapper;

	@Override
	public List<SosopdThirdPlatformAccountExtend> queryUserPlatformAccount(SosopdUser operator) throws ServiceException {
		ParamValidator.assertNotNull(operator, "用户不能为空");
		
		return thirdPlatformAccountMapper.selectUserThirdPlarformAccount(operator.getUserId());
	}

	@Override
	public int addUserThirdPlatformAccount(SosopdUser operator,ThirdPlatformCreateParams platformAccount) throws ServiceException {
		ParamValidator.assertNotNull(operator, "用户不能为空");
		ParamValidator.assertNotNull(platformAccount, "平台账号不能为空");
		
		SosopdThirdPlatformAccount account = new SosopdThirdPlatformAccount();
		BeanUtils.copyProperties(platformAccount,account);
		account.setUserId(operator.getUserId());
		account.setStatus("reviewing");
		account.setCreateDatetime(new Date());
		return 	thirdPlatformAccountMapper.insertSelective(account);
	}

}
