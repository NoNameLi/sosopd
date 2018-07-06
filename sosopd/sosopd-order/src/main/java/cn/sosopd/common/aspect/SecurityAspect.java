package cn.sosopd.common.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.sosopd.common.anno.IgnoreSecurity;
import cn.sosopd.common.exception.extend.AJAXTokenException;
import cn.sosopd.common.exception.extend.HtmlTokenException;
import cn.sosopd.common.util.SysConsts;
import cn.sosopd.common.util.UserTokenLocal;
import cn.sosopd.common.util.WebContextUtil;
import cn.sosopd.user.entity.SosopdUser;

/**
 * Title:安全检查切面(是否登录检查) Description: 通过验证Token维持登录状态
 * 
 */
@Component
@Aspect
public class SecurityAspect {

    private static final Logger log = LoggerFactory.getLogger(SecurityAspect.class);

    private static final String LOG_METHOD_KEY = "Method ： ";

    private static final String TOKEN_INVALID_MESSAGE = "用户未登录";

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {

        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        log.debug(LOG_METHOD_KEY + method.getName() + " : " + method.isAnnotationPresent(IgnoreSecurity.class));
        // 若目标方法忽略了安全性检查,则直接调用目标方法
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return pjp.proceed();
        }
        SosopdUser user = UserTokenLocal.getCurrentUser();
        // 检查 user 有效性
        if (null == user) {
            String ajaxHeader = WebContextUtil.getRequest().getHeader(SysConsts.DEFAULT_AJAX_HEAD_NAME);
            if (SysConsts.DEFAULT_AJAC_HEAD_VALUE.equalsIgnoreCase(ajaxHeader)) {// is
                throw new AJAXTokenException(TOKEN_INVALID_MESSAGE);
            } else {
                throw new HtmlTokenException(TOKEN_INVALID_MESSAGE);
            }

        }
        // 调用目标方法
        return pjp.proceed();
    }
}
