package com.guorui.officewe.vo.my;

import lombok.Data;

/**
 * @author Hazsly
 * @date 2018/4/11 17:47
 */
@Data
public class My {
    private Integer code;

    private String msg;

    private My2 Date;

    public static My success(My2 data){

        My my = new My();
        my.setCode(0);
        my.setMsg("成功");
        my.setDate(data);
        return my;
    }
}
