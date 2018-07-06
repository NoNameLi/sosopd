package cn.sosopd.param.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sosopd.param.entity.SosopdArea;
import cn.sosopd.param.entity.SosopdAreaExample;
import cn.sosopd.param.mapper.SosopdAreaMapper;
import cn.sosopd.param.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    SosopdAreaMapper mapper;

    @Override
    public List<SosopdArea> listAreaByParentId(Short parentId) {
        SosopdAreaExample example = new SosopdAreaExample();
        if (null == parentId) {
            example.createCriteria().andParentIdEqualTo((short) 0);
        } else {
            example.createCriteria().andParentIdEqualTo(parentId);
        }
        return mapper.selectByExample(example);
    }

    @Override
    public SosopdArea listAreaByAreaId(Short id) {

        return mapper.selectByPrimaryKey(id);
    }

}
