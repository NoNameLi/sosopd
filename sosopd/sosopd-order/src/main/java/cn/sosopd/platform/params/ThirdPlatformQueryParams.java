package cn.sosopd.platform.params;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThirdPlatformQueryParams implements Serializable {

	private static final long serialVersionUID = -5148213053113543629L;

	private String platformType;
	
	private String dockingStatus;
	
	private String presetStatus;
	
}
