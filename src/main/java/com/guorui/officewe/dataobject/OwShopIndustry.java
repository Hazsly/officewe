package com.guorui.officewe.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**商品配置信息
 * @author Hazsly
 * @date 2018/4/14 11:34
 */
@Entity
@Data
@DynamicUpdate
public class OwShopIndustry {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer shopId;

    private String name;

    private String icon;
}
