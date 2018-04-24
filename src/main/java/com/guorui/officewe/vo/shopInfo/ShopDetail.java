package com.guorui.officewe.vo.shopInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/** 商品温馨提示
 * @author Hazsly
 * @date 2018/4/13 17:19
 */
@Data
public class ShopDetail {

    private String title;

    @JsonProperty("text")
    private String value;
}
