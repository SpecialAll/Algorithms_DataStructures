package com.zxh.leetcode.byteDance;

/**
 * 题目描述：
 *  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @author ningque
 */
public class MaxProfit {
    public int maxProfit(int[] price){
        int len = price.length;
        int dp_i_1 = Integer.MIN_VALUE, dp_i_0 = 0;
        for(int i=0; i<len; i++){
            dp_i_0 = Math.max(dp_i_0, dp_i_0 - price[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i_1 + price[i]);
        }
        return dp_i_0;
    }

    /**
     * 转换为求最大子序列和的方式
     *
     * @param price
     * @return
     */
    public int maxProfit_2(int[] price){
        if(price.length == 0) {
            return 0;
        }
        int[] value = new int[price.length];
        value[0] = price[0];
        for(int i=1; i<price.length; i++){
            value[i] = price[i] - price[i-1];
        }

        return maxSum(value);
    }

    private int maxSum(int[] value) {
        int ans = 0;
        for(int i=1; i<value.length; i++){
            value[i] += Math.max(value[i-1], 0);
            ans = Math.max(value[i], ans);
        }
        return ans;
    }
}
