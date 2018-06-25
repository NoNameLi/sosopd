package cn.sosopd.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import cn.sosopd.param.service.SystemDictionaryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-all.xml" })
public class DistionaryServiceTest {

	@Autowired
	private SystemDictionaryService dictionaryService;

	@Test
	public void queryParams() {

		System.out.println(JSON.toJSONString(dictionaryService.getOrderGuaranteeParams(), true));
		System.out.println(JSON.toJSONString(dictionaryService.getOrderServiceTypeParams(),true));
		System.out.println(JSON.toJSONString(dictionaryService.getOrderStatusParams(),true));
	}
	
	
}
