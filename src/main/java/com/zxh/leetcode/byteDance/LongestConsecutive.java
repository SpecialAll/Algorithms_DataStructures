package com.zxh.leetcode.byteDance;

import java.util.Arrays;

/**
 * 题目描述：
 *  给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LongestConsecutive {
    public int longestConsecutive(int nums[]){
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        Arrays.sort(nums);
        int length = nums.length - 1;
        int i = 1, max = 0, temp = 1;
        while(i <= length){
            if(nums[i-1] + 1 == nums[i] ){
                i++;
                temp++;
            }else if(nums[i-1] == nums[i]){
                i++;
            } else{
                if(max < temp){
                    max = temp;
                }
                temp = 1;
                i++;
            }
        }
        if(max < temp)
            max = temp;
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0,1};
        System.out.println("最大长度为： "+new LongestConsecutive().longestConsecutive(nums));
    }
}
