package com.guorui.officewe.enums;

import lombok.Getter;

/**
 * @author Hazsly
 * @date 2018/3/9 17:03
 */
@Getter
public enum ShopStatusEnum {

        UP(0,"上架状态"),
        DOWN(1,"下架状态"),
        ;

        private Integer code;
        private String msg;

        ShopStatusEnum(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }
}


