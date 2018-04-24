package com.guorui.officewe.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**商品详情信息
 * @author Hazsly
 * @date 2018/4/14 11:35
 */
@Data
@Entity
@DynamicUpdate
public class OwShopPrompt {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer shopId;

    private String value;

}
