package com.zxh.algorithms.interview;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/16
 */
public class SumOf1 {
    //统计一个正整数中1的个数
    public static int Sum(int number){
        int count = 0;
        while(number != 0){
            count += 1;
            number &= (number-1);
        }
        return count;
    }

    public static int Sum_2(int number){
        int count = 0;
        while (number != 0){
            count += number&1;
            number >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Sum(7));
        System.out.println(Sum_2(7));
    }
}
