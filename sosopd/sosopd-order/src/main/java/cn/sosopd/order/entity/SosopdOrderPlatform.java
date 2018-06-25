package cn.sosopd.order.entity;

import java.util.Date;

import lombok.Data;
@Data
public class SosopdOrderPlatform {
    /**
     * 派单工单id
     */
    private Integer orderId;

    /**
     * 所属平台id
     */
    private Integer platformId;

    /**
     * 派单成功平台工单的id
     */
    private String platformOrderId;

    /**
     * 派单成功平台的工单号
     */
    private String platformOrderNumber;

    /**
     * 平台工单的状态
     */
    private String platformOrderStatus;

    /**
     * 平台的工单服务人员
     */
    private String serviceManName;

    /**
     * 平台的工单服务电话
     */
    private String serviceManPhone;

    /**
     * 平台派单时间
     */
    private Date platformAssignDatetime;

    /**
     * 平台接受时间
     */
    private Date platformAcceptDatetime;

    /**
     * 平台预约时间
     */
    private Date platformAppointmenDatetime;

    /**
     * 平台的完工时间
     */
    private Date platformFinishDatetime;

}