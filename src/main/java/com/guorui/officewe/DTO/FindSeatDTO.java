package com.guorui.officewe.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Hazsly
 * @date 2018/3/22 14:46
 */
@Data
public class FindSeatDTO {

    private Integer id;

    @JsonProperty("img")
    private String shopImg;

    @JsonProperty("name")
    private String shopName;

    /** 从类目表里去查*/
    @JsonProperty("roomType")
    private String name;

    @JsonProperty("area")
    private String shopArea;

    @JsonProperty("size")
    private BigDecimal shopSizeEnd;

    @JsonProperty("seat")
    private String shopSeat;

    @JsonProperty("price")
    private BigDecimal price;
}
