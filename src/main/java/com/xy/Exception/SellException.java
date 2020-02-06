package com.xy.Exception;

import com.xy.enums.SellExceptionEnum;

/**
 * Created by wxy on 2017/10/21.
 */
public class SellException extends RuntimeException {

   private Integer code;

    public SellException(SellExceptionEnum exceptionEnum) {

        super(exceptionEnum.getMessage());
        this.code=exceptionEnum.getCode();
    }


    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
