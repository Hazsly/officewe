package com.guorui.officewe.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author Hazsly
 * @date 2018/4/13 10:28
 */
@Data
@Entity
@DynamicUpdate
public class OwUserPay {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;

    private BigDecimal amount;

    private Integer orderId;

    private Integer orderSerialNumber;

    private Integer type;

    private Integer status;


}
