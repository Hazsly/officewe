package com.guorui.officewe.vo.index;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Hazsly
 * @date 2018/4/4 16:08
 */
@Data
public class SeatVO {

    @JsonProperty("shopIcon")
    private String shopImg;

    @JsonProperty("name")
    private String shopName;

    /** 从商品类目表去查*/
    @JsonProperty("roomType")
    private String name;

    @JsonProperty("people")
    private Integer shopPeople;

    @JsonProperty("size")
    private BigDecimal shopSizeEnd;

    @JsonProperty("price")
    private String deposit;
}
