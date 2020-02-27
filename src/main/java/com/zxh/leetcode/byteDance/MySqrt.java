package com.zxh.leetcode.byteDance;

/**
 * 题目描述;
 *  实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 *
 * 解题思路：
 *  使用二分法求解，我们应该知道一个数的平方根是不会超过自己的，不会超过自身的一半！！！
 *  故而使用二分法来求解；
 */
public class MySqrt {
    public int mySqrt(int x){
        if(x == 0)
            return 0;
        if(x == 1)
            return 1;
        //如果中点 mid 声明为 int 类型，针对大整型测试用例通不过，因此变量需要声明为 long 类型!!!!
        long left = 1;
        long right = x / 2;
        while (left < right){
            long mid = (left + right + 1) >>> 1;
            long temp = mid * mid;
            if(temp > x)
                right = mid - 1;
            else
                left = mid;
        }
        return (int)left;
    }

    /**
     * 今天看到一个时间复杂度更低的算法：牛顿迭代法
     * 可以控制精度
     *
     */
    public static double sqrt(double n){
        if (n < 0) {
            return Double.NaN;
        }
        double e = 1e-1;
        double x = n;
        double y = (x + n/x) / 2;
        while (Math.abs(x - y) > e){
            x = y;
            y = (x + n/x)/2;
        }
        return x;
    }
    public static void main(String[] args) {
        System.out.println(sqrt(12));
    }
}
