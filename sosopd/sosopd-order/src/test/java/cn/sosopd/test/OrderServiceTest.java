package cn.sosopd.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.order.entity.SosopdOrder;
import cn.sosopd.order.params.CreateOrderParams;
import cn.sosopd.order.service.SosopdOrderService;
import cn.sosopd.user.entity.SosopdUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-all.xml" })
public class OrderServiceTest {

	@Autowired
	private SosopdOrderService orderService;

	public void testAddOrder() {
		SosopdUser operator = new SosopdUser().setUserId(2);
		CreateOrderParams orderData = new CreateOrderParams();
		orderData.setBrand("美的").setCustAddress("广东省深圳市宝安区XCCCCC");
		try {
			orderService.saveOrder(operator, orderData);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	public void testUpdateOrder() {
		SosopdUser operator = new SosopdUser().setUserId(2);
		SosopdOrder order = new SosopdOrder();
		order.setOrderId(3);
		order.setCustName("李四");
		order.setCustPhone("1644131515");
		try {
			orderService.updateOrder(operator, order);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteOrder() {
		SosopdUser operator = new SosopdUser().setUserId(2);
		try {
			orderService.deleteOrder(operator, 4);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
}
