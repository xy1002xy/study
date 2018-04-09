package com.xy.util;

import java.util.Random;

/**
 * Created by wxy on 2017/10/21.
 * 生成唯一主键
 * 随机数 时间+六位随机数
 */
public class KeyUtil {

    public static String getUniqueKey(){

        Random random=new Random();
        Integer number=random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);

    }

    public static void main(String[]args){
        String id=getUniqueKey();
        System.out.println(id);
    }



    }



