package com.guorui.officewe.dataobject;

import com.guorui.officewe.enums.OrderStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Hazsly
 * @date 2018/3/23 15:59
 */
@Entity
@DynamicUpdate
@Data
public class OwOrder {

    @Id
    @GeneratedValue
    private Integer id;

    /** 商品id*/
    private Integer shopId;

    /** 用户id*/
    private Integer userId;

    /** 商品规格*/
    private String shopInfo;

    /** 商品名称*/
    private String shopName;

    /** 订单号*/
    private Integer shopNumber;

    /** 总价格*/
    private BigDecimal price;

    /** 支付方式：1.微信 2.支付宝*/
    private Integer paymentType;

    /** 订单状态*/
    private Integer status = OrderStatusEnum.NEW.getCode();

    /** 创建时间*/
    private Date createtime;

    /** 支付时间*/
    private Date paymentTime;
}
