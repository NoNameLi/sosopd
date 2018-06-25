package cn.sosopd.param.service.impl.converter;

import java.util.ArrayList;
import java.util.List;

import cn.sosopd.common.dto.CommonParamDto;
import cn.sosopd.param.entity.SosopdSystemDictionary;

public class DictionaryConverter {

	public static CommonParamDto converCommon(SosopdSystemDictionary data) {
		CommonParamDto dto = new CommonParamDto();
		if (null != data) {
			dto.setId(String.valueOf(data.getId()));
			dto.setText(data.getValue());
		}
		return dto;
	}

	public static List<CommonParamDto> converCommon(List<SosopdSystemDictionary> data) {
		List<CommonParamDto> list = new ArrayList<>();
		if (null != data) {
			for (SosopdSystemDictionary item : data) {
				list.add(converCommon(item));
			}
		}
		return list;
	}
}
