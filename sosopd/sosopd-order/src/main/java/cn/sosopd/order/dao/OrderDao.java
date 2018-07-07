package cn.sosopd.order.dao;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.common.validator.BeanValidator;
import cn.sosopd.common.validator.ParamValidator;
import cn.sosopd.order.entity.SosopdOrder;
import cn.sosopd.order.entity.SosopdOrderExtend;
import cn.sosopd.order.mapper.SosopdOrderMapper;
import cn.sosopd.order.params.QueryOrderParams;
import cn.sosopd.order.params.UpdateOrderCondition;

@Service
public class OrderDao {

    @Autowired
    private SosopdOrderMapper sosopdOrderMapper;

    public SosopdOrder getOrderById(Integer operator, Integer orderId) throws ServiceException {
        checkOperator(operator);
        return sosopdOrderMapper.selectByPrimaryKey(operator, orderId);
    }

    public List<SosopdOrder> listorder(Integer operator, Integer... orderIds) throws ServiceException {
        checkOperator(operator);
        ParamValidator.assertNotNull(orderIds, "");
        return sosopdOrderMapper.selectByPrimaryKeys(operator, orderIds);
    }

    public List<SosopdOrderExtend> listOrderByParams(Integer operator, QueryOrderParams params)
            throws ServiceException {
        checkOperator(operator);
        return sosopdOrderMapper.queryOrderByParams(operator, params);
    }

    public void saveOrder(Integer operator, SosopdOrder order) throws ServiceException {
        checkOperator(operator);
        ParamValidator.assertNotNull(order, "添加工单工单数据不能为空");
        order.setUserId(operator);
        order.setCreateDatetime(DateTime.now().toDate());
        sosopdOrderMapper.insertSelective(order);
    }

    public void updateOrder(Integer operator, SosopdOrder order) throws ServiceException {
        checkOperator(operator);
        UpdateOrderCondition condition = new UpdateOrderCondition().setOrderId(order.getOrderId()).setUserId(operator)
                .setUpdateDatetime(order.getUpdateDatetime());
        BeanValidator.validate(condition);
        order.setUpdateDatetime(new Date());
        sosopdOrderMapper.updateByRowLock(condition, order);
    }

    public void updateOrderBatch(Integer operator, List<SosopdOrder> orders) {
        for (SosopdOrder item : orders) {
            item.setUserId(operator);
        }
        sosopdOrderMapper.updateBatch(orders);
    }

    private void checkOperator(Integer operator) throws ServiceException {
        ParamValidator.assertNotNull(operator, "查找工单用户不能为空");
    }
}
