package com.liujin.code;
//从1～5随机到1～7随机
public class Code08_RandToRand {
    // 此函数只能用，不能修改
    // 等概率返回1~5
    public static int randomNum(){
        int num = (int) ((Math.random() * 5)+1);
        return num;
    }
    // 等概率得到0和1 发生器
    public static int f(){
        int san = 0;
        do{
            san = randomNum();
        }while (san == 3);
        return san < 3 ? 0 : 1;
    }
    // 等概率返回1~7
    public static int f1(){
        int san = 0;
        do {
            san = (f() << 2) + (f() << 1) + (f() <<0);
        }while (san == 0);
        return san;
    }

    public static void main(String[] args) {
        int i = f1();
        System.out.println(i);

    }



}
