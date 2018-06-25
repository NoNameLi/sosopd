package cn.sosopd.common.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * service 层 页面查询统一返回数据封装对象
 * @author Administrator
 *
 */
@Data
public class PageQueryDataDto implements Serializable{
	
	private static final long serialVersionUID = 7944875560037175211L;

	private long total;
	
	private List<?> rows;
}
