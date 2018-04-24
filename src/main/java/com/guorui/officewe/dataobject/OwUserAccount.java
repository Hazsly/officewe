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
 * @date 2018/3/14 16:37
 */
@Entity
@DynamicUpdate
@Data
public class OwUserAccount {

    @Id
    @GeneratedValue
    private Integer accountId;


    private Integer userId;

    private BigDecimal userBalance;

    private Integer userIntegral;

    private Date createTime;

    private Date updateTime;

}
