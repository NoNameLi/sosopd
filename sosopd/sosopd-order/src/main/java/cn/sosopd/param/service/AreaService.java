package cn.sosopd.param.service;

import java.util.List;

import cn.sosopd.param.entity.SosopdArea;

public interface AreaService {

	List<SosopdArea> getProvinceArea();

	List<SosopdArea> getAreaByParentId();

	SosopdArea getAreaByAreaId();
}