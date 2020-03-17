package com.zxh.leetcode.exercise;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/9
 */

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class LengthOfLIS {
    /**
     * 第一种解法：使用动态规划，但是复杂度是O(n^2)
     */
    public int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            dp[i] = 1;
        }
        for(int i=0; i<nums.length; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<dp.length; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * 解法二：动态规划+二分法  时间复杂度O(nlgn)
     * dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
     *        由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
     *        对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
     *        1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
     *          数组尾部, 并将最长递增序列长度maxL加1
     *        2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
     * @param nums
     * @return
     */
    public int lengthOfLSI_2(int[] nums){
        int dp[] = new int[nums.length];
        int piles = 0;
        for(int i=0; i<nums.length; i++){
            int temp = nums[i];
            int left = 0,right = piles;
            while(left < right){
                int mid = (left + right) / 2;
                if(dp[mid] > temp){
                    right = mid;
                } else if(dp[mid] < temp){
                    left = mid + 1;
                } else{
                    right = mid;
                }
            }
            if(left == piles)
                piles++;
            dp[left] = temp;
        }

        return piles;
    }
}
