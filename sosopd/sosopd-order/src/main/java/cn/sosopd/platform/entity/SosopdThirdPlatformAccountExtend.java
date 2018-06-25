package cn.sosopd.platform.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)// 
public class SosopdThirdPlatformAccountExtend extends SosopdThirdPlatformAccount{
	
	private String statusName;
	
}
