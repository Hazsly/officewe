package com.guorui.officewe.vo.shopInfo;

import lombok.Data;

/**
 * @author Hazsly
 * @date 2018/4/13 16:21
 */
@Data
public class ShopInfoVO {

    private Integer code;

    private String msg;

    private Shop2 data;


    public static ShopInfoVO success(Shop2 data){
        ShopInfoVO shopInfoVO = new ShopInfoVO();
        shopInfoVO.setCode(0);
        shopInfoVO.setMsg("成功");
        shopInfoVO.setData(data);
        return shopInfoVO;
    }
}
