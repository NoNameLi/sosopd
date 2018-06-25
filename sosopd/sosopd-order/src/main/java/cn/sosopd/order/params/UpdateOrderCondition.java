package cn.sosopd.order.params;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 更新工单条件 用于避免更新出错 类似于 数据库行锁 工单id, 用户id, 等等
 * 
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class UpdateOrderCondition implements Serializable {
	private static final long serialVersionUID = 1549472494337443417L;

	/**
	 * 工单ID
	 */
	@NotNull(message = "更新工单 工单ID不能为空")
	private Integer orderId;

	/**
	 * 工单所属用户ID
	 */
	@NotNull(message = "更新工单 操作者不能为空")
	private Integer userId;

	/**
	 * 更新时间
	 */
	private Date updateDatetime;

}
