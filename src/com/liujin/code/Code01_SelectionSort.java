package com.liujin.code;
//选择排序 求最小
public class Code01_SelectionSort {

    //替换元素
    public static void swap(int [] arr, int j, int i){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void selectionSort(int[] arr){
        //边界条件 不能等于空或者小于二
        if(arr == null || arr.length<2){
            return;
        }
        for (int i = 0; i < arr.length-1; i++){
            //当前最小数
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }
    //遍历数组
    public static void printArray(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"/");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] arr = {10,5,7,2,9,21,15,3};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }

}
