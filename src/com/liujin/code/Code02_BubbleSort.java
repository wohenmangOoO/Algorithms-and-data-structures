package com.liujin.code;
//冒泡排序 求最大
public class Code02_BubbleSort {
    //替换元素
    public static void swap(int [] arr, int j, int i){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void bubbleSort(int [] arr){
        //边界条件
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = arr.length-1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    //打印数组
    public static void printArray(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"/");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] arr = {10,5,7,2,9,21,15,3};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
