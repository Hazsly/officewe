package com.guorui.officewe.vo.shopInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Hazsly
 * @date 2018/4/13 17:09
 */
@Data
public class ShopTop {

    private Integer shopId;

    private String shopImg;

    private String shopName;

    private BigDecimal price;

    @JsonProperty("shopSize")
    private BigDecimal shopSizeEnd;

    private String shopSeat;

    private String useTime;

    private String address;

}
