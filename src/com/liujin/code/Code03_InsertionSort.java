package com.liujin.code;

public class Code03_InsertionSort {
    //替换元素
    public static void wasp(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void insertionSort(int [] arr){
        //边界条件
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length-1; i++){
            for (int j = i -1; j >= 0 && arr[j] > arr[j+1]; j--){
                wasp(arr,j,j+1);
            }
        }
    }
    //打印数组
    public static void printArray(int [] arr){
        for (int i = 0; i < arr.length-1; i++){
            System.out.print(arr[i]+"/");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] arr = {10,5,7,2,9,21,15,3};
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }
}
