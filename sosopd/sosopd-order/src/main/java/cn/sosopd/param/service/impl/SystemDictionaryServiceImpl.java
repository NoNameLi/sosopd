package cn.sosopd.param.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sosopd.common.dto.CommonParamDto;
import cn.sosopd.param.entity.SosopdSystemDictionary;
import cn.sosopd.param.mapper.SosopdSystemDictionaryMapper;
import cn.sosopd.param.service.SystemDictionaryService;
import cn.sosopd.param.service.impl.converter.DictionaryConverter;
import cn.sosopd.param.type.DictionaryBaseTypeEnum;

@Service
public class SystemDictionaryServiceImpl implements SystemDictionaryService {

    @Autowired
    private SosopdSystemDictionaryMapper systemDictionaryMapper;

    @Override
    public List<SosopdSystemDictionary> listOrderStatusParams() {
        return this.listDictionaryDataByTypeKey(DictionaryBaseTypeEnum.ORDER_STATUS_TYPE.name());
    }

    @Override
    public List<SosopdSystemDictionary> listOrderServiceTypeParams() {
        return this.listDictionaryDataByTypeKey(DictionaryBaseTypeEnum.ORDER_SERVICE_TYPE.name());
    }

    @Override
    public List<CommonParamDto> listOrderServiceTypeBriefly() {

        List<SosopdSystemDictionary> list = this.listOrderServiceTypeParams();
        return DictionaryConverter.converCommon(list);
    }

    @Override
    public List<SosopdSystemDictionary> listOrderGuaranteeParams() {

        return this.listDictionaryDataByTypeKey(DictionaryBaseTypeEnum.ORDER_GUARANTEE_TYPE.name());
    }

    @Override
    public List<SosopdSystemDictionary> listPlatformTypeParams() {
        return this.listDictionaryDataByTypeKey(DictionaryBaseTypeEnum.PLATFORM_TYPE_TYPE.name());
    }

    @Override
    public List<SosopdSystemDictionary> listDictionaryDataByTypeKey(String typeKey) {
        return systemDictionaryMapper.selectByType(typeKey);
    }

}
