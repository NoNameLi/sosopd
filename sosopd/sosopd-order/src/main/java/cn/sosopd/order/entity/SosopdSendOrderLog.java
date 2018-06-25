package cn.sosopd.order.entity;

import java.util.Date;

import lombok.Data;

@Data
public class SosopdSendOrderLog {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 报表日期
     */
    private Date date;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 平台ID
     */
    private Integer platfromId;

    /**
     * 用户平台派单总量
     */
    private Integer sendOrderCount;

    /**
     * 用户平台派单成功总量
     */
    private Integer sendSuccessCount;

    /**
     * 用户平台派单失败总量
     */
    private Integer sendFailCount;

}