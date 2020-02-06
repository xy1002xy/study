package com.xy.homework;

import java.util.Random;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-04-16 21:41
 * @desc:
 **/
public class RandomNumber {
    protected Random random = new Random();
    protected int currentRandomNumber = 0;

    public RandomNumber()
    {

    }

    public int generateRandomNumber()
    {
        currentRandomNumber = random.nextInt();
        return currentRandomNumber;
    }

    public int getCurrentRandomNumber() { return currentRandomNumber; }


    int Easy = (int)(Math.random() * 20.0D) + 1;
    int Normal = (int)(Math.random() * 100.0D) + 1;
    int Hard = (int)(Math.random() * 20.0D) + 1;



    public int getEasy() {
        return this.Easy;
    }

    public void setEasy(int easy) {
        this.Easy = easy;
    }

    public int getNormal() {
        return this.Normal;
    }

    public void setNormal(int normal) {
        this.Normal = normal;
    }

    public int getHard() {
        return this.Hard;
    }

    public void setHard(int hard) {
        this.Hard = hard;
    }



}
