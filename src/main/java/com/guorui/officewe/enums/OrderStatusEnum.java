package com.guorui.officewe.enums;

import lombok.Getter;

/**
 * @author Hazsly
 * @date 2018/4/14 14:30
 */
@Getter
public enum OrderStatusEnum {

    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
