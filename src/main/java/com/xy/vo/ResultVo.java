package com.xy.vo;

import lombok.Data;

/**
 * http 请求返回的最外层对象
 * Created by wxy on 2017/9/23.
 */
@Data
public class ResultVo<T> {

    /**
     * 错误码
     */
    private Integer code;


    /**
     *提示信息
     */
    private String msg;
    /**
     * 商品信息
     */
    private T data;
}
