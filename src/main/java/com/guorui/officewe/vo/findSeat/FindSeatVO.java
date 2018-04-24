package com.guorui.officewe.vo.findSeat;

import lombok.Data;

/**
 * @author Hazsly
 * @date 2018/3/12 15:49
 */
@Data
public class FindSeatVO {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private ShopDataVO data;

    public static FindSeatVO success(ShopDataVO data) {
        FindSeatVO seatVO = new FindSeatVO();
        seatVO.setData(data);
        seatVO.setCode(0);
        seatVO.setMsg("成功");
        return seatVO;
    }
}
