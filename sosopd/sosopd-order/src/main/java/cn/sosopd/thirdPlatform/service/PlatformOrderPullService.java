package cn.sosopd.thirdPlatform.service;

import java.util.List;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.thirdPlatform.dto.SearchOrderDto;

/**
 * 平台工单拉取服务
 * 
 * @author remote
 *
 */
public interface PlatformOrderPullService {
    // 抓单
    String catchOrder(String account, String pwd);

    // 工单搜索
    List<Object> searchOrderByParams(String account, String password, SearchOrderDto searchOrderCondition);

    // 工单查询信息
    Object queryOrderById(String account, String pwd, String orderId);

    // 查询结算单
    List<Object> searhcSettleOrderByParams(String account, String password, SearchOrderDto searchOrderCondition)
            throws ServiceException;
}
