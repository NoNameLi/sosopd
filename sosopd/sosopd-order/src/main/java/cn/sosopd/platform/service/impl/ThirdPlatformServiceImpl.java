package cn.sosopd.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sosopd.common.dto.CommonParamDto;
import cn.sosopd.platform.entity.SosopdThirdPlatformExtend;
import cn.sosopd.platform.mapper.SosopdThirdPlatformMapper;
import cn.sosopd.platform.params.ThirdPlatformQueryParams;
import cn.sosopd.platform.service.ThirdPlatformService;
import cn.sosopd.platform.service.converter.PlatformConverter;
import cn.sosopd.platform.type.PlatformPresetEnum;

@Service
public class ThirdPlatformServiceImpl implements ThirdPlatformService {

    @Autowired
    private SosopdThirdPlatformMapper thirdPlatformMapper;

    /**
     * 根据类型查询预设平台
     */
    public List<SosopdThirdPlatformExtend> listPlatformByType(String platformType) {

        ThirdPlatformQueryParams params = ThirdPlatformQueryParams.builder().platformType(platformType)
                .presetStatus(PlatformPresetEnum.SHOW.key).build();
        return this.listPlatformByParams(params);
    }

    @Override
    public List<SosopdThirdPlatformExtend> listPlatformByParams(ThirdPlatformQueryParams params) {
        return thirdPlatformMapper.selectByParams(params);
    }

    @Override
    public List<CommonParamDto> listPlatform() {

        ThirdPlatformQueryParams params = ThirdPlatformQueryParams.builder().presetStatus(PlatformPresetEnum.SHOW.key)
                .build();
        List<SosopdThirdPlatformExtend> list = this.listPlatformByParams(params);

        return PlatformConverter.converCommonDataDto(list);
    }

    /*
     * public List<SosopdThirdPlatform>
     * queryPlatformByParams(ThirdPlatformQueryParams params){
     * PageHelper.startPage(page, pageSize); List<SosopdThirdPlatform> list =
     * thirdPlatformMapper.selectByParams(params); PageInfo<SosopdThirdPlatform>
     * pageInfo = new PageInfo<>(list); pageInfo.getTotal()
     * 
     * return; }
     */

}
