package cn.sosopd.common.dto;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class JQueryDataTableResponseData implements Serializable {
	private static final long serialVersionUID = -1268746396368769406L;

	private String draw;

	// 记录
	private Object data;

	// 总记录数
	private Long recordsTotal;
	// 当前记录数
	private Long recordsFiltered;

	public JQueryDataTableResponseData() {

	}

	public JQueryDataTableResponseData(String draw, List<?> data, Long recordsTotal, Long recordsFiltered) {
		this.draw = draw;
		this.data = data;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
	}

	public static JQueryDataTableResponseData buildResponseDataFromPageInfo(JQueryDataTableParam param,
			PageInfo<?> pageInfo) {

		return buildResponseData(param, pageInfo.getList(), pageInfo.getTotal());
	}

	public static JQueryDataTableResponseData buildResponseData(JQueryDataTableParam param, List<?> data, Long total) {
		JQueryDataTableResponseData responseData = new JQueryDataTableResponseData();
		responseData.setDraw(null == param ? "1" : param.getDraw());
		if (null == data) {
			responseData.setData(null).setRecordsTotal(0L).setRecordsFiltered(0L);
		} else {
			responseData.setData(data).setRecordsTotal(total).setRecordsFiltered(total);
		}
		return responseData;
	}
}
