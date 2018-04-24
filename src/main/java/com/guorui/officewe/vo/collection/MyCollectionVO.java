package com.guorui.officewe.vo.collection;

import lombok.Data;

/**
 * @author Hazsly
 * @date 2018/4/12 15:32
 */
@Data
public class MyCollectionVO {

    private Integer code;

    private String msg;

    private Collection data;

    public static MyCollectionVO success(Collection data){
        MyCollectionVO myCollectionVO = new MyCollectionVO();
        myCollectionVO.setCode(0);
        myCollectionVO.setMsg("成功");
        myCollectionVO.setData(data);
        return myCollectionVO;
    }

}
