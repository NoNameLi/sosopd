package cn.sosopd.param.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sosopd.common.dto.Response;
import cn.sosopd.common.util.SysConsts;
import cn.sosopd.param.entity.SosopdSystemDictionary;
import cn.sosopd.param.service.SystemDictionaryService;

/**
 * 系统字典控制器
 * 
 * @author Administrator
 *
 */

@Controller
@RequestMapping(SysConsts.REQUEST_URL_PREFIX + "/systemDictionary")
public class SystemDictionaryController {

    @Autowired
    private SystemDictionaryService systemDictionaryService;

    @RequestMapping("/getPlatformType.json")
    @ResponseBody
    public Response getPlatformType() {
        List<SosopdSystemDictionary> list = systemDictionaryService.listPlatformTypeParams();
        return new Response().success(list);
    }

    @RequestMapping("/getGuaranteeType.json")
    @ResponseBody
    public Response getGuaranteeType() {
        List<SosopdSystemDictionary> list = systemDictionaryService.listOrderGuaranteeParams();
        return new Response().success(list);
    }

    @RequestMapping("/getOrderTypeBriefly.json")
    @ResponseBody
    public Response getOrderTypeBriefly() {
        return new Response().success(systemDictionaryService.listOrderServiceTypeBriefly());
    }

    // orderTypeCondition:[{"name":"全部","value":""},{"name":"维修","value":"01"},{"name":"安装","value":"02"}],

}
