package cn.sosopd.param.type;
/**
 * 数据字典中的基本类型
 * @author remote
 *
 */
public enum DictionaryBaseType {
	
	account_status_type("账号有效类型"),
	order_guarantee_type("工单质保类型"),
	order_service_type("工单服务类型"),
	order_status_type("工单状态类型"),
	platform_account_status_type("第三方平台账号状态类型"),
	platform_docking_type("第三方平台对接状态类型"),
	platform_preset_type("平台预设状态类型数据"),
	platform_type_type("平台分类类型"),
	order_source_type("工单信息来源类型");

	private String desc;

	private DictionaryBaseType(String desc) {
		this.desc = desc;
	}

	public String desc() {
		return this.desc;
	}
	
}
