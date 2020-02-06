package com.xy.homework;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-04-16 22:14
 * @desc:
 **/
public final class GetRandomNUmber extends RandomNumber {

    private int minNum;
    private int maxNum;

    public GetRandomNUmber() {
    }

    public GetRandomNUmber(int minNum, int maxNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
    }

    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int GenerateRandomNumber(int minNum,int maxNum){
        int num=0;
        RandomNumber randomNumber=new RandomNumber();
        GetRandomNUmber getRandomNUmber=new GetRandomNUmber(minNum,maxNum);
        while (true){
            if (num>getRandomNUmber.getMinNum() && num<getRandomNUmber.getMaxNum())
               // num=randomNumber.generateRandomNumber();
            break;
        }

        return num;
    }

}


