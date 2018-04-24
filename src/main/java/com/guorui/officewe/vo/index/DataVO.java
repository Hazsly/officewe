package com.guorui.officewe.vo.index;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/2/7 11:59
 */
@Data
public class DataVO {

    @JsonProperty("banner")
    private List<BannerVO> bannerVO;

    @JsonProperty("recommend")
    private RecommendVO recommendVO;
}
