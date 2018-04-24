package com.guorui.officewe.vo.configure;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Hazsly
 * @date 2018/3/21 16:08
 */
@Data
public class ConfigVO {
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 用户绑定手机. */
    @JsonProperty("tel")
    private String username ;
}
