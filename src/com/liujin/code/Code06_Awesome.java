package com.liujin.code;

//局部最小值问题 arr[0]<arr[1]   arr[0]>arr[?]<arr[len] arr[len-1]>arr[len]
public class Code06_Awesome {
    // arr 相邻的数不相等！
    public static int oneMinIndex(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid - 1] > arr[mid] && arr[mid + 1] > arr[mid]){
                return mid;
            }else {
                if (arr[mid] > arr[mid - 1]){
                    R = mid - 1;
                }else {
                    L = mid + 1;
                }
            }

        }
        return arr[L] < arr[R] ? L : R;
    }
    // 生成随机数组，且相邻数不相等
    public static int [] randomArray(int maxLen, int maxValue){
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }
    //对数器
    public static boolean chack(int [] arr, int minIndex){
        if (arr.length == 0){
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }
    //打印数组
    public static void printArray(int [] arr){
        for (int num : arr) {
            System.out.print(num + "");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int testTime = 10;
        int maxLen = 10;
        int maxValue = 20;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++){
            int[] arr = randomArray(maxLen, maxValue);
            int minIndex = oneMinIndex(arr);
            if(!chack(arr,minIndex)){
                System.out.println("出错了");
                printArray(arr);
                System.out.println(minIndex);
            }
        }
        System.out.println("测试结束 没问题");
    }
}
