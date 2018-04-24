package com.guorui.officewe.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Hazsly
 * @date 2018/2/6 16:03
 */
@Entity
@DynamicUpdate
@Data
public class OwRecommend {
    /** 热门推荐id. */
    @Id
    @GeneratedValue
    private Integer recommendId;

    /** 热门推荐类型 */
    private Integer recommendType;

    /** 热门推荐名称 */
    private String recommendName;

    /** 热门推荐图片地址*/
    private String recommendIcon;

    /** 热门推荐备注描述*/
    private String recommendDescription;
}
