package cn.sosopd.param.service;

import java.util.List;

import cn.sosopd.param.entity.SosopdArea;

public interface AreaService {

    List<SosopdArea> listAreaByParentId(Short parentId);

    SosopdArea listAreaByAreaId(Short id);
}