package cn.sosopd.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true) //
public class SosopdOrderExtend extends SosopdOrder {

    private String platformName;
    private String orderStatusName;
    private String custProvinceName;
    private String custCityName;
    private String custCountyName;
    private String guaranteeName;
    private String serviceTypeName;
    private String orderSourceName;
}