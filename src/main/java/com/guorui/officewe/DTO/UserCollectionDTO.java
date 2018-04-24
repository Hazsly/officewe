package com.guorui.officewe.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Hazsly
 * @date 2018/3/23 12:49
 */
@Data
public class UserCollectionDTO {

    @JsonProperty("id")
    private Integer shopId;

    @JsonProperty("img")
    private String shopImg;

    @JsonProperty("name")
    private String shopName;

    @JsonProperty("roomType")
    private String name;

    @JsonProperty("area")
    private String shopArea;

    @JsonProperty("size")
    private BigDecimal shopSize;

    @JsonProperty("seat")
    private String shopSeat;

    @JsonProperty("price")
    private BigDecimal price;
}
