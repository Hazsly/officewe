package com.guorui.officewe.vo.myInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Hazsly
 * @date 2018/4/12 11:22
 */
@Data
public class MyInfo2 {

    @JsonProperty("myInfo")
    private MyInfoVO myInfoVO;
}
