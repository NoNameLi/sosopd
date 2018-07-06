package cn.sosopd.order.params;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 工单创建时 必要的信息
 * 
 * @author remote
 *
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CreateOrderParams implements Serializable {
    private static final long serialVersionUID = 7648090173812135713L;

    /**
     * 工单所属用户ID
     */
    private Integer userId;

    /**
     * 工单派发平台ID
     */
    private Integer platformAccountId;

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

}
