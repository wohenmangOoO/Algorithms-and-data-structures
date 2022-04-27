package com.liujin.code;

import java.util.Arrays;

//找num
public class Code04_FindNum {
    //在有序数组中找出num
    public static boolean find(int [] arr, int num){
        //边界条件
        if (arr.length == 0 || arr == null){
            return false;
        }
        //arr[L...R]
        int L = 0;
        int R = arr.length-1;
        while (L < R){
            int min = (L + R) / 2;
            if(arr[min] == num){
                return true;
            }else if (arr[min] < num){
                L = min + 1;
            }else {
                R = min - 1;
            }
        }
        return false;
    }
    // 返回一个数组arr，arr长度[0,maxLen-1],arr中的每个值[0,maxValue-1]
    public static int [] lenRandomValueRandom(int maxLen, int maxValue){
        int len  = (int) (Math.random() * maxLen);
        int [] arr = new int[len];
        for (int i = 0; i < len; i++){
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) ((Math.random() * maxValue));
        }
        return arr;
    }
    //判断数组里是否有num
    public static boolean equalsNum(int [] arr, int num){
        if (arr.length == 0 || arr == null){
            return false;
        }
        for (int cur : arr) {
            if (cur == num){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int maxSize = 10;
        int testTime = 5;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++){
            int[] arr = lenRandomValueRandom(maxSize, maxValue);
            Arrays.sort(arr);
            int num = (int) (Math.random() * (maxValue + 1)) - (int) ((Math.random() * maxValue));
            if (equalsNum(arr,num) != find(arr,num)){
                System.out.println("出错了");
                break;
            }
        }
        System.out.println("没问题");
    }
}

