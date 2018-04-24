package com.guorui.officewe.vo.order;

import lombok.Data;

/**
 * @author Hazsly
 * @date 2018/3/28 14:11
 */
@Data
public class OrderVO {

    /**
     * 错误码.
     */
    private Integer code;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 具体内容.
     */
    private OrderDataVO data;

    public static OrderVO success(OrderDataVO data) {
        OrderVO orderVO = new OrderVO();
        orderVO.setData(data);
        orderVO.setCode(0);
        orderVO.setMsg("成功");
        return orderVO;
    }
}