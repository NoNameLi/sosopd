package cn.sosopd.param.type;
/**
 * 数据字典中的基本类型
 * @author remote
 *
 */
public enum DictionaryBaseTypeEnum {
	
	ACCOUNT_STATUS_TYPE("账号有效类型"),
	ORDER_GUARANTEE_TYPE("工单质保类型"),
	ORDER_SERVICE_TYPE("工单服务类型"),
	ORDER_STATUS_TYPE("工单状态类型"),
	PLATFORM_ACCOUNT_status_TYPE("第三方平台账号状态类型"),
	PLATFORM_DOCKING_TYPE("第三方平台对接状态类型"),
	PLATFORM_PRESET_TYPE("平台预设状态类型数据"),
	PLATFORM_TYPE_TYPE("平台分类类型"),
	ORDER_SOURCE_TYPE("工单信息来源类型");

	private String desc;

	private DictionaryBaseTypeEnum(String desc) {
		this.desc = desc;
	}

	public String desc() {
		return this.desc;
	}
	
}
