package com.guorui.officewe.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;


/**商品表
 * @author Hazsly
 * @date 2018/3/9 15:52
 */
@Entity
@Data
@DynamicUpdate
public class OwShop {

    @Id
    @GeneratedValue
    private Integer id;

    /** 关联类目表id*/
    private Integer cId;

    /** 关联商品介绍表id*/
    private Integer dId;

    /** 商品配置*/
    private String industry;

    /** 商家类型：0.自有，1.其他*/
    private Integer shopType;

    /** 商品图片链接*/
    private String shopImg;

    /** 商品名称*/
    private String shopName;

    /** 商品所属地区，如：滨江区*/
    private String shopArea;

    /** 商品面积最小值*/
    private BigDecimal shopSizeStart;

    /** 商品面积最大值*/
    private BigDecimal shopSizeEnd;

    /** 使用人数字段，如：5个人*/
    private Integer shopPeople;

    /** 多少个工位，如：1个工位*/
    private String shopSeat;

    private Integer shopNum;

    private String useTime;

    private Integer score;

    private String address;

    private String customer;

    private BigDecimal price;

    private String deposit;

    private Integer province;

    private Integer city;

    private Integer area;

    private String longitude;

    private String latitude;

    private Integer sort;

    private Integer isRecommend;

    private Integer status;

    public OwShop(){

    }


}
