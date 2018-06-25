package cn.sosopd.param.service;

import java.util.List;

import cn.sosopd.common.dto.CommonParamDto;
import cn.sosopd.param.entity.SosopdSystemDictionary;

public interface SystemDictionaryService {
	
	/**
	 * 查询工单状态数据
	 */
	List<SosopdSystemDictionary> getOrderStatusParams();
	
	/**
	 * 查询工单服务类型
	 */
	List<SosopdSystemDictionary> getOrderServiceTypeParams();
	
	/**
	 * 查询工单服务类型 简要数据
	 */
	List<CommonParamDto> getOrderServiceTypeBriefly();
	
	/**
	 * 查询工单质保类型
	 */
	List<SosopdSystemDictionary> getOrderGuaranteeParams();
	
	/**
	 * 查询平台类型数据
	 */
	List<SosopdSystemDictionary> getPlatformTypeParams();
	
	/**
	 * 根据数据类型查询系统数据
	 */
	List<SosopdSystemDictionary> getDictionaryDataByTypeKey(String typeKey);
}
 