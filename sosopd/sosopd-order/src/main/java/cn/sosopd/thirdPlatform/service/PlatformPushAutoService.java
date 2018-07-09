package cn.sosopd.thirdPlatform.service;

import cn.sosopd.common.exception.ServiceException;

/**
 * 平台自动推送数据服务
 * 
 * @author remote
 *
 */
public interface PlatformPushAutoService {

    // 自动预约
    String autoAppointment(String account, String password) throws ServiceException;

    // 自动完工
    String autoFinish(String account, String password) throws ServiceException;
}
