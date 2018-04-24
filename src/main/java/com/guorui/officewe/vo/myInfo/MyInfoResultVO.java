package com.guorui.officewe.vo.myInfo;

import lombok.Data;

/**
 * @author Hazsly
 * @date 2018/4/12 11:20
 */
@Data
public class MyInfoResultVO {
    private Integer code;
    private String msg;
    private MyInfo2 data;

    public static MyInfoResultVO success(MyInfo2 data){
        MyInfoResultVO myInfoResultVO = new MyInfoResultVO();
        myInfoResultVO.setCode(0);
        myInfoResultVO.setMsg("成功");
        myInfoResultVO.setData(data);
        return myInfoResultVO;
    }
}
