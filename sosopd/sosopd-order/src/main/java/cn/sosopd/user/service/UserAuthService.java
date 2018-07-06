package cn.sosopd.user.service;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.user.entity.SosopdUserAuth;

/**
 * 用户认证服务 即用户的账号 创建 create 修改 update 查询
 * 
 * @author Administrator
 *
 */
public interface UserAuthService {

    Integer saveAccount(SosopdUserAuth account) throws ServiceException;

    Boolean updateAccountSelective(SosopdUserAuth account) throws ServiceException;

    SosopdUserAuth getAccountByPrimaryKey(Integer accountId) throws ServiceException;

    SosopdUserAuth checkAccount(String account, String password);
}
