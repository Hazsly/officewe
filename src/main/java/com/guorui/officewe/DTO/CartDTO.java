package com.guorui.officewe.DTO;

import lombok.Data;

/**购物车
 * @author Hazsly
 * @date 2018/2/27 16:27
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
