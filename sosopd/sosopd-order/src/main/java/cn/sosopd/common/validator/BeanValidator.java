package cn.sosopd.common.validator;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sosopd.common.exception.extend.ParamValidationException;

/**
 * Bean校验工具类
 * 
 * <pre>
 * 使用@Min、@Max、@Range注解时，必须指定message，否则框架会加载EL表达式相关API，导致发生异常：
 * java.lang.ClassNotFoundException: com.sun.el.ExpressionFactoryImpl
 * </pre>
 * 
 * @author ChenFeng
 * @date 2016年8月9日
 */
public class BeanValidator {

    private static final Logger log = LoggerFactory.getLogger(BeanValidator.class);

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public static <T> void validate(T bean, Class<?>... groups) throws ParamValidationException {
        if (bean == null) {
            return;
        }
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(bean, groups);
        if (violations.size() > 0) {
            for (ConstraintViolation<T> violation : violations) {
                log.warn("Bean校验失败，参数名：{}，错误消息：{}", violation.getPropertyPath().toString(), violation.getMessage());
                throw new ParamValidationException(violation.getMessage(), violation.getPropertyPath().toString());
            }
        }
    }

    public static <T> void validate(List<T> beans, Class<?>... groups) throws ParamValidationException {
        if (beans == null || beans.isEmpty()) {
            return;
        }
        for (Object bean : beans) {
            validate(bean, groups);
        }
    }

    public static <T> BeanValidatorResult validateAll(T bean, Class<?>... groups) {
        BeanValidatorResult result = new BeanValidatorResult();
        if (bean == null) {
            return result;
        }

        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(bean, groups);
        if (violations.size() > 0) {
            for (ConstraintViolation<T> violation : violations) {
                result.setResult(false);
                result.addMessage(violation.getPropertyPath().toString(), violation.getMessage());
            }
        }

        return result;
    }

}