package com.guorui.officewe.vo.my;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Hazsly
 * @date 2018/3/21 10:50
 */
@Data
public class MyVO {


    @JsonProperty("userId")
    private Integer id ;

    /** 用户头像. */
    @JsonProperty("icon")
    private String portrait;

    /** 用户昵称. */
    @JsonProperty("name")
    private String nickname;

    /** 用户账户余额. */
    @JsonProperty("balance")
    private BigDecimal userBalance;

}
