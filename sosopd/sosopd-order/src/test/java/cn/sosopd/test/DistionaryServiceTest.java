package cn.sosopd.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;

import cn.sosopd.param.service.AreaService;
import cn.sosopd.param.service.SystemDictionaryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-all.xml" })
public class DistionaryServiceTest {

	@Autowired
	private SystemDictionaryService dictionaryService;
	
	@Autowired
	private AreaService areaService;

	@Test
	public void queryParams() {

		System.out.println(JSON.toJSONString(dictionaryService.getOrderGuaranteeParams(), true));
		System.out.println(JSON.toJSONString(dictionaryService.getOrderServiceTypeParams(),true));
		System.out.println(JSON.toJSONString(dictionaryService.getOrderStatusParams(),true));
	}
	
	@Test
	public void getArea() {
		
		System.out.println(Json.toJson(areaService.getAreaByParentId(null), JsonFormat.nice()));
		System.out.println(Json.toJson(areaService.getAreaByParentId((short)0), JsonFormat.nice()));
		System.out.println(Json.toJson(areaService.getAreaByParentId((short)17), JsonFormat.nice()));
		
	}
	
	
}
