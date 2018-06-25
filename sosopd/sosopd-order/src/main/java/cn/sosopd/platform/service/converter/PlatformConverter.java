package cn.sosopd.platform.service.converter;

import java.util.ArrayList;
import java.util.List;

import cn.sosopd.common.dto.CommonParamDto;
import cn.sosopd.platform.entity.SosopdThirdPlatformExtend;

public class PlatformConverter {

	public static CommonParamDto converCommonDataDto(SosopdThirdPlatformExtend platform) {
		CommonParamDto data = new CommonParamDto();
		if (null != platform) {
			data.setId(String.valueOf(platform.getPlatformId()));
			data.setText(platform.getPlatfromName());
		}
		return data;
	}

	public static List<CommonParamDto> converCommonDataDto(List<SosopdThirdPlatformExtend> platforms) {
		List<CommonParamDto> data = new ArrayList<>();
		if (null != platforms) {
			for (SosopdThirdPlatformExtend item : platforms) {
				data.add(converCommonDataDto(item));
			}
		}
		return data;
	}

}
