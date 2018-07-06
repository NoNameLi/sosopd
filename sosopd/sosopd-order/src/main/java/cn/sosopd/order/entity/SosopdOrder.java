package cn.sosopd.order.entity;

import java.util.Date;

import lombok.Data;

@Data
public class SosopdOrder {
    /**
     * 工单ID
     */
    private Integer orderId;

    /**
     * 工单所属用户ID
     */
    private Integer userId;

    /**
     * 工单派发平台ID
     */
    private Integer platformAccountId;

    /**
     * 工单状态（未派、发送中、已派、失败），默认未派
     */
    private String orderStatus;

    /**
     * 工单顾客姓名
     */
    private String custName;

    /**
     * 工单顾客电话
     */
    private String custPhone;

    /**
     * 工单顾客 地址-省份
     */
    private Integer custProvince;

    /**
     * 工单顾客 地址-城市
     */
    private Integer custCity;

    /**
     * 工单顾客 地址-区县
     */
    private Integer custCounty;

    /**
     * 工单顾客 地址-详细地址
     */
    private String custAddress;

    /**
     * 产品品牌
     */
    private String brand;

    /**
     * 产品
     */
    private String product;

    /**
     * 产品型号
     */
    private String productModel;

    /**
     * 质保
     */
    private String guarantee;

    /**
     * 工单产品数量
     */
    private String productCount;

    /**
     * 服务类型
     */
    private String serviceType;

    /**
     * 工单来源（新增、导入、天猫、京东等等）
     */
    private String orderSource;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createDatetime;

    /**
     * 更新时间
     */
    private Date updateDatetime;

    /**
     * 删除标记
     */
    private String deleteFlag;
}