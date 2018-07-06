package cn.sosopd.order.dao;

import java.util.Date;
import java.util.List;

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
import cn.sosopd.user.entity.SosopdUser;

@Service
public class OrderDao {

    @Autowired
    private SosopdOrderMapper sosopdOrderMapper;

    public SosopdOrder getOrderById(SosopdUser operator, int orderId) throws ServiceException {
        ParamValidator.assertNotNull(operator, "添加工单用户不能为空");
        return sosopdOrderMapper.selectByPrimaryKey(operator.getUserId(), orderId);
    }

    public List<SosopdOrderExtend> listOrderByParams(SosopdUser operator, QueryOrderParams params) {
        return sosopdOrderMapper.queryOrderByParams(operator.getUserId(), params);
    }

    public void saveOrder(SosopdUser operator, SosopdOrder order) throws ServiceException {
        ParamValidator.assertNotNull(operator, "添加工单用户不能为空");
        ParamValidator.assertNotNull(order, "添加工单工单数据不能为空");
        sosopdOrderMapper.insertSelective(order);
    }

    public void updateOrder(SosopdUser operator, SosopdOrder order) throws ServiceException {

        UpdateOrderCondition condition = new UpdateOrderCondition().setOrderId(order.getOrderId())
                .setUserId(operator.getUserId()).setUpdateDatetime(order.getUpdateDatetime());
        BeanValidator.validate(condition);
        order.setUpdateDatetime(new Date());
        sosopdOrderMapper.updateByParams(condition, order);
    }
}
