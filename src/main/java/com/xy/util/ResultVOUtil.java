package com.xy.util;


import com.xy.vo.ResultVo;

/**
 * Created by wxy on 2017/10/19.
 */
public class ResultVOUtil {

    public  static ResultVo success(Object obj){
        ResultVo resultVo=new ResultVo();
        resultVo.setCode(1);
        resultVo.setMsg("成功");
        resultVo.setData(obj);
        return resultVo;
    }

    public  static ResultVo success(){
        return success(null);
    }

    public  static ResultVo error(Integer code,String msg){
        ResultVo resultVo=new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
