package cn.sosopd.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.order.dao.OrderDao;
import cn.sosopd.order.entity.SosopdOrder;
import cn.sosopd.order.params.CreateOrderParams;
import cn.sosopd.order.service.SosopdOrderService;
import cn.sosopd.order.type.OrderStatusEnum;
import cn.sosopd.user.entity.SosopdUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-all.xml" })
public class OrderServiceTest {

    @Autowired
    private SosopdOrderService orderService;

    @Autowired
    private OrderDao orderDao;

    @Test
    public void testDaoUpdateBatch() {
        List<SosopdOrder> orders = new ArrayList<>();

        Date now = DateTime.now().toDate();
        orders.add(new SosopdOrder().setOrderId(1).setPlatformAccountId(2)
                .setOrderStatus(OrderStatusEnum.SENDING.name()).setUpdateDatetime(now));
        orders.add(new SosopdOrder().setOrderId(3).setPlatformAccountId(2)
                .setOrderStatus(OrderStatusEnum.SENDING.name()).setUpdateDatetime(now));
        orders.add(new SosopdOrder().setOrderId(4).setPlatformAccountId(2)
                .setOrderStatus(OrderStatusEnum.SENDING.name()).setUpdateDatetime(now));

        orderDao.updateOrderBatch(2, orders);
    }

    @Test
    public void testLists() {

        try {
            System.out.println(Json.toJson(orderDao.listorder(2), JsonFormat.nice()));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
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
