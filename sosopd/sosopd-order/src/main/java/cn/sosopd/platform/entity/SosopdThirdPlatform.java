package cn.sosopd.platform.entity;

import lombok.Data;

@Data
public class SosopdThirdPlatform {
    /**
     * 平台记录id
     */
    private Integer platformId;

    /**
     * 平台名称
     */
    private String platfromName;

    /**
     * 平台分类
     */
    private String platformType;

    /**
     * 平台对接状态
     */
    private String dockingStatus;

    /**
     * 平台登录网址
     */
    private String loginWebSite;

    /**
     * 预设展示状态
     */
    private String presetStatus;

    /**
     * 预设展示排序
     */
    private Integer presetSort;

    /**
     * 平台官方网址
     */
    private String officialWebSite;

}