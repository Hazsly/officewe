package com.guorui.officewe.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @author Hazsly
 * @date 2018/2/26 17:19
 */
@Data
public class OrderDTO {

    /**
     * 订单id.
     */
    @JsonProperty("orderId")
    private Integer id;

    /**
     * 订单编号
     * */
    @JsonProperty("orderNumber")
    private Integer shopNumber;

    /**
     * 商品图片.从商品表去查
     */
    private String shopImg;

    /**
     * 商品名称.
     */
    private String shopName;

    /**
     * 租期（例如：1个月）.
     */
    private String shopTime;

    /**
     * 到期时间.
     */
    private String shopUntilTime;

    /**
     * 多少个人（例如：2个人）.目前只有工位需要填写
     */
    private String shopPersonNumber;

    /**
     * 预付定金价格.从用户交易记录表去查
     */
    private BigDecimal price;

    /**
     * 支付状态，默认为未支付.
     */
    private Integer status;
}

