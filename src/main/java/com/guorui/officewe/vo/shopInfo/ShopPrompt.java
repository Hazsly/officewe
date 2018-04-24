package com.guorui.officewe.vo.shopInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/** 商品详细信息
 * @author Hazsly
 * @date 2018/4/13 17:20
 */
@Data
public class ShopPrompt {

    @JsonProperty("text")
    private String value;
}
