package cn.sosopd.platform.service;

import java.util.List;

import cn.sosopd.common.dto.CommonParamDto;
import cn.sosopd.platform.entity.SosopdThirdPlatformExtend;
import cn.sosopd.platform.params.ThirdPlatformQueryParams;

public interface ThirdPlatformService {

	/**
	 * 根据类型查询预设平台
	 */
	List<SosopdThirdPlatformExtend> queryPlatformByType(String platformType);

	/**
	 * 根据参数查询预设平台
	 */
	List<SosopdThirdPlatformExtend> queryPlatformByParams(ThirdPlatformQueryParams params);

	/**
	 * 获取预设的平台{id，name} 数据
	 * 
	 * @return
	 */
	List<CommonParamDto> getPlatform();

}
