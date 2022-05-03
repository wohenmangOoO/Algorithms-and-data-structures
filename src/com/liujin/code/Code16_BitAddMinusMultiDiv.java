package com.liujin.code;
//使用位运算来实现加减乘除
// 测试链接：https://leetcode.com/problems/divide-two-integers
public class Code16_BitAddMinusMultiDiv {
    //加
    public static int add(int a, int b){
        int sum = a;
        while (b != 0){
            sum = a ^ b; //无进位相加信息
            b = (a & b) <<1; //进位信息
            a = sum;
        }
        return sum;
    }
    //减多少就是加他的相反数 取反加一
    public static int negNum(int n){
        return add(~n, 1);
    }
    //减
    public static int minus(int a, int b){
        return add(a,negNum(b));
    }
    //乘
    public static int multi(int a, int b){
        int res = 0;
        while (b != 0){
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;//如果不带符号(>>)就按符号位来补齐，如果带符号（>>>）按0补齐
        }
        return res;
    }
    //判断是否是正整数
    public static boolean isNeg(int n){
        return n < 0;
    }
    //除
    public static int div(int a, int b){
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = minus(i,1)){
            if ((x >> i) >=  y){
              res |= (1 << i);
              x = minus(x,y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }
    /**
     * 四种情况：
     * a、b都是系统最小值
     * b是系统最小值
     * a是系统最小值
     * a、b都不是系统最小值
     */
    public static int divide(int a, int b){
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE){
            return 1;
        }else if (b == Integer.MIN_VALUE){
            return 0;
        }else if (a == Integer.MIN_VALUE){
            /**
             * a/b -10/2
             * (a+1)/b=c max:（-10+1)/b=-4
             * a-c*b=d    -10-2*-4=-2
             * d/b=e       -2/2= -1 向下取整
             * c+e         -4+-1=-5
             */
            if (b == negNum(1)){
                return Integer.MAX_VALUE;
            }else {
                int c = div(add(a,1),b);
                return add(c,div(minus(a,multi(c,b)),b));
            }

        }else {
            return div(a,b);
        }
    }

}
