package cn.sosopd.thirdPlatform.service;

import java.util.List;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.thirdPlatform.dto.PartnerItemData;
import cn.sosopd.thirdPlatform.dto.PartnerOrderSealDto;
import cn.sosopd.thirdPlatform.dto.ThirdOtherBaseWidthCheckDto;

/**
 * 平台 其他数据 拉取服务
 * 
 * @author remote
 *
 */
public interface PlatformOtherPullService {

    /** 抓故障现象列表 */
    List<Object> serachMalfunctionJson(String account, String pwd, ThirdOtherBaseWidthCheckDto dto)
            throws ServiceException;

    /** 抓故服务措施 */
    List<Object> serachMeasuresJson(String account, String pwd, ThirdOtherBaseWidthCheckDto dto)
            throws ServiceException;

    /** 抓故故障原因 */
    List<Object> serachCauseJson(String account, String pwd, ThirdOtherBaseWidthCheckDto dto) throws ServiceException;

    // 获取工单厂商页面路径
    PartnerOrderSealDto getOrderDetailsPageData(String account, String password, String id, String serviceType,
            String orderStatus) throws ServiceException;

    // 查询产品信息
    List<PartnerItemData> searchOrderProduct(String account, String pwd, String partnerOrderId, String productMode)
            throws ServiceException;
}
