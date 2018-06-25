package cn.sosopd.platform.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)// 
public class SosopdThirdPlatformExtend extends SosopdThirdPlatform {
	
	private String platformTypeName;
	
	private String dockingStatusName;
	
	private String presetStatusName;
}
