package com.zxh.algorithms.interview;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/17
 */

/**
 * 题目描述：
 * 求比整数N小的所有正整数中，各位数字乘积最大者，如输入220，返回199
 */
public class MaxNumber {
    public static int maxNumber(int num){
        if(num < 10){
            return num;
        }
        if(num == 10)
            return 9;
        int count = 0;
        while (num > 10){
            num /= 10;
            count++;
        }
        int ans = 9;
        if(num == 10){
            int temp = 2;
            while(temp <= count){
                ans = ans*10 + 9;
                temp++;
            }
            ans = ans * 10 + 9;
        } else {
            int temp = 2;
            while(temp <= count){
                ans = ans*10 + 9;
                temp++;
            }
            double x = count;
            ans = ans + (int)Math.pow(10.0, x);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxNumber(100));
    }
}
