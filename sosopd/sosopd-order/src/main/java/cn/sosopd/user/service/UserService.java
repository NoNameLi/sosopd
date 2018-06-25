package cn.sosopd.user.service;

import java.util.List;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.user.entity.SosopdUser;
import cn.sosopd.user.param.UserDto;

/**
 * 用户服务 创建 create 修改 update 查询
 * 
 * @author Administrator
 *
 */
public interface UserService {

	Integer createUser(SosopdUser user) throws ServiceException;

	Boolean updateUserInfo(int userId, UserDto user) throws ServiceException;

	SosopdUser queryUserById(Integer userId) throws ServiceException;

	List<SosopdUser> selectUserByParams() throws ServiceException;

}
