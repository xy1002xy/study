package com.xy.homework;

import java.util.Scanner;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-04-16 23:02
 * @desc:
 **/
public class PlayGame {
    public int count=0;
    private GetRandomNUmber random;
    private String inputStr ="";

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public GetRandomNUmber getRandom() {
        return random;
    }

    public void setRandom(GetRandomNUmber random) {
        this.random = random;
    }

    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;

    }

    public boolean menu(){
        Scanner sc=new Scanner(System.in);
        boolean flag=false;
        int ac=0;
        System.out.println("欢迎你试玩猜数字游戏");
        System.out.println("请按[ 1 简单 2 中等 3 复杂 0 退出]");
        while (ac ==0 || ac ==1 || ac ==2  || ac ==3 ){

             ac=sc.nextInt();
            if (ac==0)
                System.exit(0);
            if (ac==1){
                flag=true;
                System.out.println("========easy=====");
            }
            if (ac==2){
                flag=true;
                System.out.println("========normal=====");
            }
            if (ac==3){
                flag=true;
                System.out.println("========hard=====");
            }

            while (!flag){
                System.out.println("========输入的数字不对，请重新输入=====");
                ac=sc.nextInt();
            }
        }
           return true;
    }




}
