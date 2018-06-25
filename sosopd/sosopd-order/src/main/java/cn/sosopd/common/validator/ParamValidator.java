package cn.sosopd.common.validator;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sosopd.common.exception.extend.ParamValidationException;

/**
 * 业务层参数校验，校验不通过就抛ParamValidationException异常
 * 
 * @author ChenFeng
 * @date 2016年12月9日
 */
public class ParamValidator {

	private static final Logger log = LoggerFactory.getLogger(BeanValidator.class);

	/**
	 * 断言参数为true，否则抛ParamValidationException异常
	 * 
	 * @param param
	 * @param errorMessage
	 * @throws ParamValidationException
	 */
	public static void assertTrue(boolean param, String errorMessage) throws ParamValidationException {
		if (param == false) {
			log.warn("参数校验失败，错误消息：{}", errorMessage);
			throw new ParamValidationException(errorMessage);
		}
	}

	/**
	 * 断言参数不能为null，否则抛ParamValidationException异常
	 * 
	 * @param param
	 * @param errorMessage
	 * @throws ParamValidationException
	 */
	public static void assertNotNull(Object param, String errorMessage) throws ParamValidationException {
		if (param == null) {
			log.warn("参数校验失败，错误消息：{}", errorMessage);
			throw new ParamValidationException(errorMessage);
		}
	}

	/**
	 * 断言参数不能为空，否则抛ParamValidationException异常
	 * 
	 * @param param
	 * @param errorMessage
	 * @throws ParamValidationException
	 */
	public static void assertNotEmpty(String param, String errorMessage) throws ParamValidationException {
		if (StringUtils.isEmpty(param)) {
			log.warn("参数校验失败，错误消息：{}", errorMessage);
			throw new ParamValidationException(errorMessage);
		}
	}

	/**
	 * 断言参数不能为空，否则抛ParamValidationException异常
	 * 
	 * @param param
	 * @param errorMessage
	 * @throws ParamValidationException
	 */
	public static void assertNotEmpty(Long param, String errorMessage) throws ParamValidationException {
		if (null == param) {
			log.warn("参数校验失败，错误消息：{}", errorMessage);
			throw new ParamValidationException(errorMessage);
		}
	}

	/**
	 * 断言参数不能为空，否则抛ParamValidationException异常
	 * 
	 * @param listParam
	 * @param errorMessage
	 * @throws ParamValidationException
	 */
	public static void assertNotEmpty(List<?> listParam, String errorMessage) throws ParamValidationException {
		if (listParam == null || listParam.isEmpty()) {
			log.warn("参数校验失败，错误消息：{}", errorMessage);
			throw new ParamValidationException(errorMessage);
		}
	}

	/**
	 * 校验单个值在可能值范围之内
	 * 
	 * @param errorMessage
	 * @param param
	 * @param possibleValues
	 * @return
	 * @throws ParamValidationException
	 */
	public static boolean assertInPossibleValues(String errorMessage, String param, List<String> possibleValues)
			throws ParamValidationException {
		if (StringUtils.isEmpty(param)) {
			return false;
		}

		if (!possibleValues.contains(param)) {
			log.warn("参数校验失败，错误消息：{}", errorMessage);
			throw new ParamValidationException(errorMessage);
		}

		return true;
	}

	/**
	 * 校验多个值在可能值范围之内
	 * 
	 * @param errorMessage
	 * @param params
	 * @param possibleValues
	 * @return
	 * @throws ParamValidationException
	 */
	public static boolean assertInPossibleValues(String errorMessage, List<String> params, List<String> possibleValues)
			throws ParamValidationException {
		if (params == null || params.isEmpty()) {
			return true;
		}

		for (String param : params) {
			if (!possibleValues.contains(param)) {
				log.warn("参数校验失败，错误消息：{}", errorMessage);
				throw new ParamValidationException(errorMessage);
			}
		}

		return true;
	}

	/**
	 * 校验多个list要不全部为null，要不全部不为null且size相同
	 * 
	 * @param errorMessage
	 * @param listParams
	 * @return
	 * @throws ParamValidationException
	 */
	public static boolean assertListSizeSame(String errorMessage, List<?>... listParams)
			throws ParamValidationException {
		if (listParams == null || listParams.length < 2) {
			return false;
		}

		// 如果第1个list为null，那么后续所有list都应该为null，否则抛异常
		if (listParams[0] == null) {
			for (int i = 1; i < listParams.length; i++) {
				if (listParams[i] != null) {
					log.warn("参数校验失败，错误消息：{}", errorMessage);
					throw new ParamValidationException(errorMessage);
				}
			}
		}
		// 如果第1个list不为null，那么后续所有list都应该不为null，且所有list的size相同，否则抛异常
		else {
			int sizeOfFirst = listParams[0].size();
			for (int i = 1; i < listParams.length; i++) {
				if (listParams[i] == null || listParams[i].size() != sizeOfFirst) {
					log.warn("参数校验失败，错误消息：{}", errorMessage);
					throw new ParamValidationException(errorMessage);
				}
			}
		}

		return true;
	}

}