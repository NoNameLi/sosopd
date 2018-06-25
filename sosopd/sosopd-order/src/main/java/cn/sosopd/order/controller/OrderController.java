package cn.sosopd.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.sosopd.common.dto.JQueryDataTableParam;
import cn.sosopd.common.dto.JQueryDataTableResponseData;
import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.common.util.SysConstants;
import cn.sosopd.common.util.UserTokenLocal;
import cn.sosopd.common.validator.ParamValidator;
import cn.sosopd.order.params.CreateOrderParams;
import cn.sosopd.order.params.QueryOrderParams;
import cn.sosopd.order.service.SosopdOrderService;

@Controller
@RequestMapping(SysConstants.REQUEST_URL_PREFIX + "/order")
public class OrderController {

	@Autowired
	private SosopdOrderService orderService;

	@RequestMapping("/list.json")
	@ResponseBody
	public JQueryDataTableResponseData queryOrderByPage(HttpServletRequest request, QueryOrderParams params) {
		JQueryDataTableParam jqp = JQueryDataTableParam.buildParams(request);
		PageInfo<?> pageInfo = orderService.queryOrdersByPage(UserTokenLocal.getCurrentUser(), jqp.convter(), params);
		return JQueryDataTableResponseData.buildResponseDataFromPageInfo(jqp, pageInfo);
	}

	@RequestMapping("/sendOrderToPlatform.json")
	@ResponseBody
	public void sendOrder2Paltform(List<Integer> orderIds, Integer platformAccountId) throws ServiceException {
		ParamValidator.assertNotNull(orderIds, "工单数据不能为空");
		ParamValidator.assertNotNull(platformAccountId, "派单对象不能为空");
	}

	@RequestMapping("/addOrder.json")
	@ResponseBody
	public void addOrderByUser(CreateOrderParams orderData) throws ServiceException {

		orderService.createOrder(UserTokenLocal.getCurrentUser(), orderData);

	}
}
