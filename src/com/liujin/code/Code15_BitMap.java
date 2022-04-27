package com.liujin.code;
//位图功能实现
//一个字节（byte）等于8个（bit）一个整数32位占4字节
public class Code15_BitMap {
    public static class BitMap{
        private long [] bits;
        public BitMap(int max){
            bits = new long[(max + 64) >> 6];
        }
        public void add(int num){
            bits[num >> 6] |= (1L << (num & 63));
        }
        public void delete(int num){
            bits[num >> 6] &= ~ (1L << (num & 63));
        }
        public boolean contains(int num){
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }
}
