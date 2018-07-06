package cn.sosopd.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sosopd.common.anno.IgnoreSecurity;
import cn.sosopd.common.util.SysConsts;

@Controller
@RequestMapping(SysConsts.REQUEST_URL_PREFIX)
@SuppressWarnings("unchecked")
public class ViewMappingController {

    /** URL请求的前缀 */
    protected static final String REQUEST_URL_PREFIX = SysConsts.REQUEST_URL_PREFIX;
    /** 视图文件目录前缀 */
    protected static final String VIEWS_PATH_PREFIX = SysConsts.REQUEST_URL_PREFIX;

    @RequestMapping(value = "/login.html")
    @IgnoreSecurity
    public ModelAndView loginMapping(HttpServletRequest request) {
        Map<String, String[]> paramMap = request.getParameterMap();
        Map<String, String> paramDataMap = new HashMap<>();
        for (String paramKey : paramMap.keySet()) {
            if (null != paramMap.get(paramKey) && paramMap.get(paramKey).length > 0) {
                paramDataMap.put(paramKey, paramMap.get(paramKey)[0]);
            }
        }

        return new ModelAndView(VIEWS_PATH_PREFIX + "/login").addAllObjects(paramDataMap);
    }

    @RequestMapping(value = "/{viewName}.html")
    public ModelAndView viewMapping(HttpServletRequest request, @PathVariable String viewName) {
        Map<String, String[]> paramMap = request.getParameterMap();
        Map<String, String> paramDataMap = new HashMap<>();
        for (String paramKey : paramMap.keySet()) {
            if (null != paramMap.get(paramKey) && paramMap.get(paramKey).length > 0) {
                paramDataMap.put(paramKey, paramMap.get(paramKey)[0]);
            }
        }
        return new ModelAndView(VIEWS_PATH_PREFIX + "/" + viewName).addAllObjects(paramDataMap);
    }

    @RequestMapping(value = "/{path1}/{viewName}.html")
    public ModelAndView viewMapping(HttpServletRequest request, @PathVariable String path1,
            @PathVariable String viewName) {
        Map<String, String[]> paramMap = request.getParameterMap();
        Map<String, String> paramDataMap = new HashMap<>();
        for (String paramKey : paramMap.keySet()) {
            if (null != paramMap.get(paramKey) && paramMap.get(paramKey).length > 0) {
                paramDataMap.put(paramKey, paramMap.get(paramKey)[0]);
            }
        }

        return new ModelAndView(VIEWS_PATH_PREFIX + "/" + path1 + "/" + viewName).addAllObjects(paramDataMap);
    }

    @RequestMapping(value = "/{path1}/{path2}/{viewName}.html")
    public ModelAndView viewMapping(HttpServletRequest request, @PathVariable String path1, @PathVariable String path2,
            @PathVariable String viewName) {
        Map<String, String[]> paramMap = request.getParameterMap();
        Map<String, String> paramDataMap = new HashMap<>();
        for (String paramKey : paramMap.keySet()) {
            if (null != paramMap.get(paramKey) && paramMap.get(paramKey).length > 0) {
                paramDataMap.put(paramKey, paramMap.get(paramKey)[0]);
            }
        }

        return new ModelAndView(VIEWS_PATH_PREFIX + "/" + path1 + "/" + path2 + "/" + viewName)
                .addAllObjects(paramDataMap);
    }

}