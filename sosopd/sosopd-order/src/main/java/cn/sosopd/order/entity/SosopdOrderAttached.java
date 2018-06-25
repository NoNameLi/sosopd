package cn.sosopd.order.entity;

import lombok.Data;

@Data
public class SosopdOrderAttached {
    /**
     * 工单ID
     */
    private Integer orderId;

    /**
     * 属性ID
     */
    private String attributeKey;

    /**
     * 属性值
     */
    private String attributeValue;
}