package com.guorui.officewe.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Hazsly
 * @date 2018/3/14 15:20
 */
@Entity
@DynamicUpdate
@Data
public class OwUser {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private int type;

    /** 用户头像*/
    private String portrait;

    private Integer age;

    private Integer sex;

    /** 客户端类型：0 安卓， 1 IOS*/
    private Integer clientType;

    /** 消息通知开启：0 开启 ，1 关闭*/
    private Integer mesStatus;

    private Integer status;

    private String unionid;

    private String openId;

    private Date createtime;

}
