package cn.sosopd.platform.type;

public enum PlatformPresetEnum {
	
	SHOW("show","预设显示"),
	NOSHOW("noshow","不显示");
	
	public String key;
	public String desc;
	
	private PlatformPresetEnum(String key,String desc){
		this.key = key;
		this.desc = desc;
	}
	
}
