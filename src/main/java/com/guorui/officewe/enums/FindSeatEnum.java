package com.guorui.officewe.enums;

import lombok.Getter;

/**
 * @author Hazsly
 * @date 2018/3/26 14:46
 */
@Getter
public enum FindSeatEnum {

    ALL(10,"所有商品"),
    ;

    private Integer code;
    private String msg;

    FindSeatEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
