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

		System.out.println(JSON.toJSONString(dictionaryService.listOrderGuaranteeParams(), true));
		System.out.println(JSON.toJSONString(dictionaryService.listOrderServiceTypeParams(),true));
		System.out.println(JSON.toJSONString(dictionaryService.listOrderStatusParams(),true));
	}
	
	@Test
	public void listArea() {
		
		System.out.println(Json.toJson(areaService.listAreaByParentId(null).size(), JsonFormat.nice()));
		System.out.println(Json.toJson(areaService.listAreaByParentId((short)0).size(), JsonFormat.nice()));
		System.out.println(Json.toJson(areaService.listAreaByParentId((short)17).size(), JsonFormat.nice()));
		
	}
	
	
}
