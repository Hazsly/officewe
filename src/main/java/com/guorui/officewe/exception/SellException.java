package com.guorui.officewe.exception;

import com.guorui.officewe.enums.ResultEnum;

/**
 * @author Hazsly
 * @date 2018/4/14 14:59
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
