package com.zxh.nowCoder.jianzhi_offer;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/17
 *
 * 题目描述：
 *  给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 *
 *
 * 根据指数的正负进行分类操作！！！1
 */
public class Power {
    public double power(double base, int exponent){
        if(exponent == 0)
            return 1;
        double ans = 1;
        while(exponent > 0){
            ans *= base ;
            exponent--;
        }
        int temp = 1;
        while(exponent < 0){
            temp *= base;
            exponent++;
            ans = (1.0)/temp;
        }
        return ans;
    }
}
