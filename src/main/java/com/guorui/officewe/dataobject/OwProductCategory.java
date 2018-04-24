package com.guorui.officewe.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**首页类目模块
 * @author Hazsly
 * @date 2018/3/9 11:34
 */
@Entity
@DynamicUpdate
@Data
public class OwProductCategory {

    /** 类目id.*/
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名称.*/
    private String categoryName;

    /** 类目编号.*/
    private Integer categoryType;


}
