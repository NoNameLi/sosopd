package cn.sosopd.order.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sosopd.common.dto.PageParams;
import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.order.dao.OrderDao;
import cn.sosopd.order.entity.SosopdOrder;
import cn.sosopd.order.entity.SosopdOrderExtend;
import cn.sosopd.order.params.CreateOrderParams;
import cn.sosopd.order.params.QueryOrderParams;
import cn.sosopd.order.service.SosopdOrderService;
import cn.sosopd.order.type.OrderStatusEnum;
import cn.sosopd.platform.dao.ThirdPlatformAccountDao;
import cn.sosopd.platform.entity.SosopdThirdPlatformAccountExtend;
import cn.sosopd.task.dao.TaskDao;
import cn.sosopd.task.dto.TaskCreateDto;
import cn.sosopd.user.entity.SosopdUser;

@Service
public class SosopdOrderServiceImpl implements SosopdOrderService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ThirdPlatformAccountDao thirdPlatformAccountDao;

    @Autowired
    private TaskDao taskDao;

    @Override
    public List<SosopdOrderExtend> listOrderByParams(SosopdUser operator, QueryOrderParams params) {

        try {
            return orderDao.listOrderByParams(operator.getUserId(), params);
        } catch (ServiceException e) {
            log.error(Json.toJson(params), e);
            return new ArrayList<>();
        }
    }

    @Override
    public PageInfo<?> listOrdersByPage(SosopdUser operator, PageParams page, QueryOrderParams params) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<SosopdOrderExtend> list;
        try {
            list = orderDao.listOrderByParams(operator.getUserId(), params);
        } catch (ServiceException e) {
            log.error(Json.toJson(params), e);
            list = new ArrayList<>();
        }
        return new PageInfo<>(list);
    }

    public void saveOrder(SosopdUser operator, CreateOrderParams orderData) throws ServiceException {

        SosopdOrder order = new SosopdOrder();
        BeanUtils.copyProperties(orderData, order);
        order.setOrderStatus(OrderStatusEnum.NO_SEND.name());
        orderDao.saveOrder(operator.getUserId(), order);

    }

    @Transactional(rollbackFor = ServiceException.class, propagation = Propagation.REQUIRED)
    public void sendOrder2Paltform(SosopdUser operator, List<Integer> orderIds, Integer platformAccountId)
            throws ServiceException {
        // 校验数据的逻辑正确性
        Integer[] orderIdArr = new Integer[orderIds.size()];
        List<SosopdOrder> orderList = orderDao.listorder(operator.getUserId(), orderIds.toArray(orderIdArr));
        if (orderList.size() != orderIds.size()) {
            throw new ServiceException("派单工单中存在不属于用户的工单");
        }
        List<SosopdThirdPlatformAccountExtend> platformAccountList = thirdPlatformAccountDao
                .listUserPlatformAccount(operator.getUserId(), platformAccountId);
        if (null == platformAccountList || platformAccountList.isEmpty()) {
            throw new ServiceException("用户不能派单到其他人的账号中");
        }
        Date now = DateTime.now().toDate();

        // 工单更新集合
        List<SosopdOrder> orders = new ArrayList<>(orderIds.size());
        // 任务记录集合
        List<TaskCreateDto> taskDtos = new ArrayList<>();
        for (Integer orderId : orderIds) {
            orders.add(new SosopdOrder().setOrderId(orderId).setPlatformAccountId(platformAccountId)
                    .setOrderStatus(OrderStatusEnum.SENDING.name()).setUpdateDatetime(now));
            taskDtos.add(TaskCreateDto.builder().orderId(orderId).taskExecDatetime(now).build());
        }

        // 更新 工单 平台账号 ID 状态 和时间
        orderDao.updateOrderBatch(operator.getUserId(), orders);
        // 添加派单任务
        if (null == taskDao.saveOrInitTask(taskDtos)) {
            throw new ServiceException("添加任务失败");
        }
    }

    @Override
    public void deleteOrder(SosopdUser operator, Integer orderId) throws ServiceException {
        if (null == this.getOrderBasicById(operator, orderId)) {
            throw new ServiceException(MessageFormat.format("用户：{0},工单：{1} 不存在", operator.getUserId(), orderId));
        }
        SosopdOrder order = new SosopdOrder();
        order.setOrderId(orderId);
        order.setDeleteFlag("Y");
        order.setUpdateDatetime(new Date());
        orderDao.updateOrder(operator.getUserId(), order);

    }

    @Override
    public SosopdOrder getOrderBasicById(SosopdUser operator, Integer orderId) throws ServiceException {

        return orderDao.getOrderById(operator.getUserId(), orderId);
    }

    @Override
    public void updateOrder(SosopdUser operator, SosopdOrder order) throws ServiceException {

        orderDao.updateOrder(operator.getUserId(), order);
    }

}
