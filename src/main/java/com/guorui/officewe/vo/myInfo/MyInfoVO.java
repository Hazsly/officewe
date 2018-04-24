package com.guorui.officewe.vo.myInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Hazsly
 * @date 2018/3/21 15:00
 */
@Data
public class MyInfoVO {

    @JsonProperty("userId")
    private Integer id;

    /** 用户头像. */
    @JsonProperty("icon")
    private String portrait;

    /** 用户昵称. */
    @JsonProperty("name")
    private String nickname;

    /** 用户性别. */
    @JsonProperty("sex")
    private Integer sex;

}
