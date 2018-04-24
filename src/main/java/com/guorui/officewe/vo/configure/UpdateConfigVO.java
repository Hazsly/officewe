package com.guorui.officewe.vo.configure;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Hazsly
 * @date 2018/3/21 15:20
 */
@Data
public class UpdateConfigVO {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

}
