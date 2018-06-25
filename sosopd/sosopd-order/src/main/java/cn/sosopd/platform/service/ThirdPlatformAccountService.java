package cn.sosopd.platform.service;

import java.util.List;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.platform.entity.SosopdThirdPlatformAccountExtend;
import cn.sosopd.platform.params.ThirdPlatformCreateParams;
import cn.sosopd.user.entity.SosopdUser;

public interface ThirdPlatformAccountService {
	
	/**
	 * 查询用户的的第三方平台账号
	 * @param operator
	 * @return
	 * @throws ServiceException 
	 */
	List<SosopdThirdPlatformAccountExtend> queryUserPlatformAccount(SosopdUser operator) throws ServiceException;
	
	/**
	 * 用户新增第三方平台的账号
	 * @param operator
	 * @return
	 * @throws ServiceException 
	 */
	int addUserThirdPlatformAccount(SosopdUser operator,ThirdPlatformCreateParams platformAccount) throws ServiceException;
	
}
