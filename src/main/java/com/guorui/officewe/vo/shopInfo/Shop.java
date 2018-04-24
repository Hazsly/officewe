package com.guorui.officewe.vo.shopInfo;

import lombok.Data;

import java.util.List;

/**
 * @author Hazsly
 * @date 2018/4/13 17:03
 */
@Data
public class Shop {

    private ShopTop shopTop;

    private List<ShopSupport> shopSupport;

    private List<ShopDetail> shopDetail;

    private ShopPrompt shopPrompt;
}
