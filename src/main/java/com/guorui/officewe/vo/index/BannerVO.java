package com.guorui.officewe.vo.index;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Hazsly
 * @date 2018/2/5 15:57
 */
@Data
public class BannerVO {

    @JsonProperty("shopId")
    private Integer shopId;

    @JsonProperty("bannerType")
    private Integer bannerType;

    @JsonProperty("bannerIcon")
    private String banner;

    @JsonProperty("bannerAddress")
    private String bannerIcon;

}
