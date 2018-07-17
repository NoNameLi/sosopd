package cn.sosopd.order.params;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 用户派单数据封装对象
 * 
 */
@Getter
@Setter
@NoArgsConstructor
public class SendOrderDto {

	@NotNull(message = "派单工单不能没有")
	private List<Integer> orderIds;

	@NotEmpty(message = "派单对象不能没有")
	private String platformAccountId;
}
