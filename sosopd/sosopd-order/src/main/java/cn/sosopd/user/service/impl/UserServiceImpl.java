package cn.sosopd.user.service.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.common.validator.BeanValidator;
import cn.sosopd.user.entity.SosopdUser;
import cn.sosopd.user.mapper.SosopdUserMapper;
import cn.sosopd.user.param.UserDto;
import cn.sosopd.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SosopdUserMapper sosopdUserMapper;

    @Override
    public SosopdUser getUserById(Integer userId) throws ServiceException {
        if (null == userId) {
            return null;
        }
        return sosopdUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Integer saveUser(SosopdUser user) throws ServiceException {
        BeanValidator.validate(user);
        return sosopdUserMapper.insert(user);
    }

    @Override
    public Boolean updateUserInfo(int userId, UserDto userInfo) throws ServiceException {
        SosopdUser sosopdUser = new SosopdUser();
        BeanUtils.copyProperties(userInfo, sosopdUser);
        sosopdUser.setUserId(userId);
        sosopdUser.setUpdateDatetime(DateTime.now().toDate());

        if (sosopdUserMapper.updateByPrimaryKeySelective(sosopdUser) >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<SosopdUser> listUserByParams() throws ServiceException {

        return null;
    }

}
