package cn.sosopd.common.aspect;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import cn.sosopd.common.util.MyDatePropertyEditor;


/**
 * 平台控制器层切面逻辑
 * 
 * @author ChenFeng <a>http://git.oschina.net/yunzhongzhu</a>
 */
@ControllerAdvice
public class PlatformControllerAspect {

	/**
	 * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 注册日期类型绑定处理器：对于需要转换为Date类型的属性，使用DatePropertyEditor进行处理
        binder.registerCustomEditor(Date.class, new MyDatePropertyEditor());
    }

}