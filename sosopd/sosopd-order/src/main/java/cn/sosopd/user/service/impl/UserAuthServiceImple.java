package cn.sosopd.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.common.exception.extend.FinalServiceException;
import cn.sosopd.user.entity.SosopdUser;
import cn.sosopd.user.entity.SosopdUserAuth;
import cn.sosopd.user.mapper.SosopdUserAuthMapper;
import cn.sosopd.user.service.UserAuthService;
import cn.sosopd.user.service.UserService;

/**
 * 用户认证服务 即用户的账号 创建 create 修改 update 查询
 * 
 * @author Administrator
 *
 */
@Service
public class UserAuthServiceImple implements UserAuthService {

	@Autowired
	private SosopdUserAuthMapper sosopdUserAuthMapper;

	@Autowired
	private UserService userService;

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public Integer saveAccount(SosopdUserAuth account) throws ServiceException {
		Boolean hasAccount = sosopdUserAuthMapper.ishasAccount(account.getAccount());
		if (null != hasAccount && hasAccount) {
			throw new FinalServiceException("账号已存在");
		}
		SosopdUser user = new SosopdUser();
		user.setUserName(account.getAccount());
		user.setUserPhone(account.getAccount());
		account.setUserId(userService.saveUser(user));
		return sosopdUserAuthMapper.insert(account);
	}

	@Override
	public Boolean updateAccountSelective(SosopdUserAuth account) throws ServiceException {
		if (sosopdUserAuthMapper.updateByPrimaryKeySelective(account) >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public SosopdUserAuth getAccountByPrimaryKey(Integer accountId) throws ServiceException {

		return sosopdUserAuthMapper.selectByPrimaryKey(accountId);
	}

	@Override
	public SosopdUserAuth checkAccount(String account, String password) {
		SosopdUserAuth auth = sosopdUserAuthMapper.selectAccountByAccAPass(account, password);
		return auth;
	}

}
