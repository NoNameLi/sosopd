package cn.sosopd.common.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class ObjectConverter {

	public static <T, S> S convert(T t, Class<S> clazz) {
		S s = null;
		if (null != t) {
			try {
				s = clazz.newInstance();
				BeanUtils.copyProperties(t, s);
			} catch (Exception e) {
			}
		}
		return s;
	}

	public static <T, S> List<S> convert(List<T> t, Class<S> clazz) {
		List<S> dtos = new ArrayList<S>();
		if (null != t && !t.isEmpty()) {
			for (T item : t) {
				dtos.add(convert(item, clazz));
			}
		}
		return dtos;
	}

}
