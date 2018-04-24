package com.guorui.officewe.utils;

import com.guorui.officewe.vo.ResultVO;
import com.guorui.officewe.vo.index.DataVO;
import com.guorui.officewe.vo.index.IndexVO;


/**
 * @author Hazsly
 * @date 2018/2/9 11:30
 */
public class ResultVOutil {

    public static IndexVO success(DataVO dataVO){
        IndexVO indexResultVO = new IndexVO();
        indexResultVO.setData(dataVO);
        indexResultVO.setCode(0);
        indexResultVO.setMsg("成功");
        return indexResultVO;
    }

    public static IndexVO success(){
        return success(null);
    }

    public static IndexVO error(Integer code, String msg){
        IndexVO indexVO = new IndexVO();
        indexVO.setMsg(msg);
        indexVO.setCode(code);
        return indexVO;
    }

    public static ResultVO success1(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success1() {
        return success1(null);
    }

    public static ResultVO error1(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
