package cn.sosopd.param.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sosopd.common.dto.CommonParamDto;
import cn.sosopd.param.entity.SosopdSystemDictionary;
import cn.sosopd.param.mapper.SosopdSystemDictionaryMapper;
import cn.sosopd.param.service.SystemDictionaryService;
import cn.sosopd.param.service.impl.converter.DictionaryConverter;
import cn.sosopd.param.type.DictionaryBaseType;

@Service
public class SystemDictionaryServiceImpl implements SystemDictionaryService {

	@Autowired
	private SosopdSystemDictionaryMapper systemDictionaryMapper;

	@Override
	public List<SosopdSystemDictionary> getOrderStatusParams() {
		return this.getDictionaryDataByTypeKey(DictionaryBaseType.order_status_type.name());
	}

	@Override
	public List<SosopdSystemDictionary> getOrderServiceTypeParams() {
		return this.getDictionaryDataByTypeKey(DictionaryBaseType.order_service_type.name());
	}

	@Override
	public List<CommonParamDto> getOrderServiceTypeBriefly() {

		List<SosopdSystemDictionary> list = this.getOrderServiceTypeParams();
		return DictionaryConverter.converCommon(list);
	}

	@Override
	public List<SosopdSystemDictionary> getOrderGuaranteeParams() {

		return this.getDictionaryDataByTypeKey(DictionaryBaseType.order_guarantee_type.name());
	}

	@Override
	public List<SosopdSystemDictionary> getPlatformTypeParams() {
		return this.getDictionaryDataByTypeKey(DictionaryBaseType.platform_type_type.name());
	}

	@Override
	public List<SosopdSystemDictionary> getDictionaryDataByTypeKey(String typeKey) {
		return systemDictionaryMapper.selectByType(typeKey);
	}

}
