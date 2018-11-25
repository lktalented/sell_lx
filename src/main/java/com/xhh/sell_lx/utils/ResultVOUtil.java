package com.xhh.sell_lx.utils;

import com.xhh.sell_lx.vo.ResultVO;

/**
 * 封装返回 ResultVO对象的方法
 * luokai
 * 2018/10/29 0029 下午 2:28
 */
public class ResultVOUtil {
    public  static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(){
        return  success(null);
    }

    public static ResultVO error(Integer code , String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }

}
