package cn.sosopd.order.params;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 工单查询参数
 * @author Administrator
 */

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class QueryOrderParams implements Serializable {

	private static final long serialVersionUID = 2353724687686775328L;
	
	private String OrderState;
	
	private String key;
	
	private Date createDatetimeStart;
	
	private Date createDatetimeEnd;
	
	private Integer provinceId;
	
	private Integer cityId;
	
	private Integer districyId;
	
	private Integer platform;
	
	private String orderServiceType;
}
