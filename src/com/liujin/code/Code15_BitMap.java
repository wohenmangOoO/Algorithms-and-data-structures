package com.liujin.code;

import java.util.HashSet;

//位图功能实现
//一个字节（byte）等于8个（bit）一个整数32位占4字节
public class Code15_BitMap {
    public static class BitMap{
        private long [] bits;
        //创建一个需要多少长度的数组
        public BitMap(int max){
            bits = new long[(max + 64) >> 6];
        }
        //添加一个元素
        public void add(int num){
            bits[num >> 6] |= (1L << (num & 63));
        }
        //删除一个元素
        public void delete(int num){
            bits[num >> 6] &= ~(1L << (num & 63));
        }
        //是否存在
        public boolean contains(int num){
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }

    }

    public static void main(String[] args) {
        System.out.println("测试开始");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        int testTime = 10000000;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < testTime; i++){
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333){
                bitMap.add(num);
                hashSet.add(num);
            }else if (decide < 0.666) {
                bitMap.delete(num);
                hashSet.remove(num);
            }else {
                if (bitMap.contains(num) != hashSet.contains(num)){
                    System.out.println("Oops");
                    break;
                }
            }
        }
        for (int num = 0; num <= max; num++){
            if (bitMap.contains(num) != hashSet.contains(num)){
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");

    }
}
