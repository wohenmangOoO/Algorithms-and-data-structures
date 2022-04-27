package com.liujin.code;
//从a～b随机到c～d   01不等概率随机到01等概率随机
public class Code07_NoProbabilityToEtcProbability {

    // 你只能知道，x会以固定概率返回0和1，但是x的内容，你看不到！
    public static int x(){
        return Math.random() < 0.75 ? 0 : 1;
    }
    // 等概率返回0和1 概率：0=p 1=1-p p*(1-p)
    public static int y(){
        int ans = 0;
        do {
            ans = x();
        }while (ans == x());
        return ans;
    }
}
