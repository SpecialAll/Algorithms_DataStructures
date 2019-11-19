package com.zxh.leetcode.exercise;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/18
 *
 * 题目描述L：
 *  给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * 解题思路：
 *
 * 好像和以前的一道题（只出现一次的数字）有异曲同工之处。看了大家的题解，异或操作（^）是一种很好的方式，不用考虑sum越界问题。
 *
 * 举个例子：
 *
 * 0 ^ 4 = 4
 * 4 ^ 4 = 0
 * 那么，就可以不用求和，直接使用异或运算^进行 抵消，剩下的数字就是缺失的了。
 *
 * 再举个例子：
 *
 * 1^1^2^2^3 = 3
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        // int sum = nums.length;
        // for(int i=0; i<nums.length; ++i){
        //     sum ^= nums[i];
        //     sum ^= i;
        // }
        // return sum;

        //第二种解法：采用求和法
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum +=nums[i];
        }
        return nums.length * (nums.length + 1) / 2 - sum;
    }
}
