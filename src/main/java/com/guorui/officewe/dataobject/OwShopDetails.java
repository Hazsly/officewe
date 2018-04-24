package com.guorui.officewe.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**温馨提示
 * @author Hazsly
 * @date 2018/4/14 11:30
 */
@Data
@Entity
@DynamicUpdate
public class OwShopDetails {

    @Id
    @GeneratedValue
    private Integer detailsId;

    private Integer shopId;

    private String title;

    private String value;

}
