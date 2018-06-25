package cn.sosopd.order.service.impl;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import cn.sosopd.user.entity.SosopdUser;

@Service
public class SosopdOrderServiceImpl implements SosopdOrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public List<SosopdOrderExtend> queryOrderByParams(SosopdUser operator, QueryOrderParams params) {

		return orderDao.queryOrderByParams(operator, params);
	}

	@Override
	public PageInfo<?> queryOrdersByPage(SosopdUser operator, PageParams page, QueryOrderParams params) {
		PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
		List<SosopdOrderExtend> list = orderDao.queryOrderByParams(operator, params);
		return new PageInfo<>(list);
	}

	public void createOrder(SosopdUser operator, CreateOrderParams orderData) throws ServiceException {

		SosopdOrder order = new SosopdOrder();
		BeanUtils.copyProperties(orderData, order);
		orderDao.createOrder(operator, order);

	}

	public void sendOrder2Paltform(SosopdUser operator, List<Integer> orderIds, Integer platformAccountId)
			throws ServiceException {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteOrder(SosopdUser operator, Integer orderId) throws ServiceException {
		if (null == this.queryOrderBasicById(operator, orderId)) {
			throw new ServiceException(MessageFormat.format("用户：{0},工单：{1} 不存在", operator.getUserId(), orderId));
		}
		SosopdOrder order = new SosopdOrder();
		order.setOrderId(orderId);
		order.setDeleteFlag("Y");
		order.setUpdateDatetime(new Date());
		orderDao.updateOrder(operator, order);

	}

	@Override
	public SosopdOrder queryOrderBasicById(SosopdUser operator, Integer orderId) throws ServiceException {

		return orderDao.queryOrderById(operator, orderId);
	}

	@Override
	public void updateOrder(SosopdUser operator, SosopdOrder order) throws ServiceException {

		orderDao.updateOrder(operator, order);
	}
}
