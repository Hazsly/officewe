package com.guorui.officewe.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author Hazsly
 * @date 2018/4/4 17:34
 */
@Entity
@Data
@DynamicUpdate
public class OwShopClass {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String icon;

}
