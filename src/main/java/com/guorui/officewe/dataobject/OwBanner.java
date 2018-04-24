package com.guorui.officewe.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Hazsly
 * @date 2018/2/6 12:29
 */
@Entity
@DynamicUpdate
@Data
public class OwBanner {


    /** 轮播图id. */
    @Id
    @GeneratedValue
    private Integer id;

    /** 绑定的商品id*/
    private Integer shopId;

    /** 轮播图类型（跳转商品还是指定链接？） */
    private Integer bannerType;

    /** 轮播图服务器存储路径 */
    private String banner;

    /** 点击轮播图后跳转的地址*/
    private String bannerIcon;
}
