package cn.sosopd.order.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.sosopd.common.dto.PageParams;
import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.order.entity.SosopdOrder;
import cn.sosopd.order.entity.SosopdOrderExtend;
import cn.sosopd.order.params.CreateOrderParams;
import cn.sosopd.order.params.QueryOrderParams;
import cn.sosopd.user.entity.SosopdUser;

/**
 * 工单接口： 1. 创建基本工单数据 ok 2. 派单功能 3. 创建工单并派单 4. 页面条件分页查询 ok 5. 内部接口调用查询
 * 
 * 方案一： 定时任务 0. 派单接口 更新工单状态和账号ID 1. 查询 发送中的工单数据 2. 根据工单对应的 平台 和 平台账号调用不同的派单接口
 * 返回派单结果 3. 保存派单结果
 * 
 * 方案二： 线程池 1. 初始化一定数量的线程池 2. 派单接口 更新工单状态和账号ID 线程池中提交任务 3. 执行任务
 * 
 * 
 * @author Administrator
 *
 */
public interface SosopdOrderService {

    /**
     * 用户参数查询
     * 
     * @param operator
     * @param params
     * @return
     */
    List<SosopdOrderExtend> listOrderByParams(SosopdUser operator, QueryOrderParams params);

    /**
     * 用户页面分页查询
     * 
     * @return
     */
    PageInfo<?> listOrdersByPage(SosopdUser operator, PageParams page, QueryOrderParams params);

    /**
     * 查询用户工单基本数据
     * 
     * @param operato
     * @param orderId
     * @return
     * @throws ServiceException
     */
    SosopdOrder getOrderBasicById(SosopdUser operato, Integer orderId) throws ServiceException;

    /**
     * 用户添加工单基本数据
     * 
     * @param operator
     * @param orderData
     * @throws ServiceException
     */
    void saveOrder(SosopdUser operator, CreateOrderParams orderData) throws ServiceException;

    /**
     * 用户逻辑删除工单
     * 
     * @param operator
     * @param orderId
     * @throws ServiceException
     */
    void deleteOrder(SosopdUser operator, Integer orderId) throws ServiceException;

    /**
     * 发送一批工单到账号
     * 
     * @param operator
     *            操作者
     * @param orderIds
     *            工单列表
     * @param platformAccountId
     *            账号id
     * @throws ServiceException
     *             当前操作者 和 工单拥有者 账号拥有者 不一致时抛出异常
     */
    void sendOrder2Paltform(SosopdUser operator, List<Integer> orderIds, Integer platformAccountId)
            throws ServiceException;

    /**
     * 用户更新工单2
     * 
     * @throws ServiceException
     */
    void updateOrder(SosopdUser operato, SosopdOrder order) throws ServiceException;
}
