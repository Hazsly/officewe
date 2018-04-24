package com.guorui.officewe.enums;

import lombok.Getter;

/**
 * @author Hazsly
 * @date 2018/4/14 15:00
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    COLLECTION_IS_EXIST(11,"商品已存在")
    ;


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
