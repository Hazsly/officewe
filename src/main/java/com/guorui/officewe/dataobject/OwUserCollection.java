package com.guorui.officewe.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Hazsly
 * @date 2018/3/21 16:46
 */
@Entity
@DynamicUpdate
@Data
public class OwUserCollection {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;

    private Integer shopId;

    private String shopName;

    private BigDecimal shopPrice;

    /** 商品规格*/
    private  String shopSpecifications;

    /*private Date createtime;
*/
}
