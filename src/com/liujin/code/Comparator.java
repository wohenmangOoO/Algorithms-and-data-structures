package com.liujin.code;
//对数器
public class Comparator {

    // 返回一个数组arr，arr长度[0,maxLen-1],arr中的每个值[0,maxValue-1]
    public static int[] lenRandomValueRandom(int maxLen, int maxValue){
        int len =(int) (Math.random() * maxLen);
        int [] ans = new int[maxLen];
        for (int i = 0; i < len; i++){
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }
    //判断元素是否递增
    public static boolean isSorted(int [] arr){
        if (arr.length > 2){
            return true;
        }
        //当前最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (max > arr[i]){
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }
    //打印数组
    public static void printArray(int [] arr){
        for (int i = 0; i < arr.length-1; i++){
            System.out.print(arr[i]+"/");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] arr = lenRandomValueRandom(100,100);
        if (!isSorted(arr)){
            System.out.println("插入排序错误！");
        }else {
            System.out.println("插入排序正确！");
        }
    }
}
