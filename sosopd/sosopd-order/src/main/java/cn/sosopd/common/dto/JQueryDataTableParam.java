package cn.sosopd.common.dto;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

/**
 * JQuery DataTable参数对象
 */
@Data
public class JQueryDataTableParam implements Serializable {

	private static final long serialVersionUID = 3107230420172828051L;

	/**
	 * 请求序列号，对于一个页面有多个table需要控制时可以使用
	 */
	private String draw;

	/**
	 * 开始行号
	 */
	private int start;

	/**
	 * 查询条数
	 */
	private int length;

	/**
	 * 排序条件
	 */
	private String sortCondition;

	public static JQueryDataTableParam buildParams(HttpServletRequest request) {
		if (null != request.getParameter("draw") && !"".equals(request.getParameter("draw"))) {
			JQueryDataTableParam jqp = new JQueryDataTableParam();

			jqp.setDraw(request.getParameter("draw"));

			if (request.getParameter("start") != null) {
				int start = Integer.parseInt(request.getParameter("start"));
				jqp.setStart(start < 0 ? 0 : start);
			}

			if (request.getParameter("length") != null) {
				int length = Integer.parseInt(request.getParameter("length"));
				jqp.setLength(length < 0 ? 0 : length);
			}

			jqp.setSortCondition(request.getParameter("sortCondition"));

			return jqp;
		} else {
			JQueryDataTableParam jqp = new JQueryDataTableParam();

			jqp.setDraw(request.getParameter("draw"));
			jqp.setStart(0);
			jqp.setLength(999);
			return jqp;
		}
	}

	public PageParams convter() {
		return new PageParams(this.start / this.length + 1, this.length);
	}

}