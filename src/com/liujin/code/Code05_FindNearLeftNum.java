package com.liujin.code;

public class Code05_FindNearLeftNum {
    //有序数组中找出>=num最左的位置
    public static int mostLeftNoLessNumIndex(int[] arr, int num) {
        //边界条件
        if (arr == null || arr.length < 2) {
            return -1;
        }
        //arr[L...R]
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int min = (L + R) / 2;
            if (arr[min] >= num) {
                R = min - 1;
                ans = num;
            } else {
                L = min + 1;
            }
        }
        return ans;
    }
    //有序数组中找出<=num最右的位置
    public static int f(int [] arr, int num){
        //边界条件
        if (arr == null || arr.length < 2){
            return -1;
        }
        int L = 0;
        int R = arr.length-1;
        int ans = -1;
        while (L <= R){
            int max = (L + R) / 2;
            if (arr[max] <= num){
                L = max + 1;
                ans = max;
            }else {
                R = max - 1;
            }
        }
        return ans;
    }



}
