package cn.sosopd.param.service;

import java.util.List;

import cn.sosopd.param.entity.SosopdArea;

public interface AreaService {

	List<SosopdArea> getAreaByParentId(Short parentId);

	SosopdArea getAreaByAreaId(Short id);
}