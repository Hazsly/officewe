package com.guorui.officewe.vo;

import lombok.Data;

/**
 * @author Hazsly
 * @date 2018/3/22 15:29
 */
@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
