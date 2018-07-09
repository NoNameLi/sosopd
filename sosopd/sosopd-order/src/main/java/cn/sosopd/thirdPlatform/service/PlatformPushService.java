package cn.sosopd.thirdPlatform.service;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.thirdPlatform.dto.AcceptOderDto;
import cn.sosopd.thirdPlatform.dto.AppointmentDto;
import cn.sosopd.thirdPlatform.dto.AsignDto;
import cn.sosopd.thirdPlatform.dto.ChargebackDto;
import cn.sosopd.thirdPlatform.dto.FinishOrderDto;
import cn.sosopd.thirdPlatform.dto.FollowOrderDto;
import cn.sosopd.thirdPlatform.dto.ItemsBaseDto;
import cn.sosopd.thirdPlatform.dto.ThirdMainRespEntity;
import cn.sosopd.thirdPlatform.dto.ThirdPartyBaseDto;

/**
 * 平台推送数据服务
 * 
 * @author remote
 *
 */
public interface PlatformPushService {

    // 接单
    void acceptOrder(String account, String pwd, AcceptOderDto acceptOderDto);

    /** 派工单 */
    void asignOrder(String account, String pwd, AsignDto asignDto) throws ServiceException;

    /** 预约工单 */
    void appointmentOrder(String account, String pwd, AppointmentDto appointmentDto) throws ServiceException;

    // 跟踪
    void followOrder(String account, String pwd, FollowOrderDto followOrderDto);

    // 完工
    void finishOrder(String account, String pwd, FinishOrderDto<? extends ItemsBaseDto> finishOrderDto);

    /** 退工单 */
    void chargebackOrder(String account, String pwd, ChargebackDto chargebackDto) throws ServiceException;

    /** 转录工单 */
    ThirdMainRespEntity transferOrder(String account, String password, ThirdPartyBaseDto baseDto)
            throws ServiceException;
}
