package com.liujin.test;

public class Test {
    public static void print(long num){

        for (int i = 31; i>=0; i--){
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        long num = 64;
//        print(num);
        //int a = ~5
        // + 1;
        int b = 0 | 1;
        System.out.println(b);
    }
}

