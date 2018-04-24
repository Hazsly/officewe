package com.guorui.officewe.vo.shopInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Hazsly
 * @date 2018/4/13 17:03
 */
@Data
public class Shop2 {

    @JsonProperty("shopInfo")
    private Shop shop;
}
