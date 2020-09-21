package com.zxh.leetcode.byteDance;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述：
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 题目解决：
 *  这道题目其实是最长递增子序列（Longes Increasing Subsequence，简写为 LIS）的一个变种，因为很显然，每次合法的嵌套是大的套小的，相当于找一个最长递增的子序列，其长度就是最多能嵌套的信封个数。
 *
 * 但是难点在于，标准的 LIS 算法只能在数组中寻找最长子序列，而我们的信封是由 (w, h) 这样的二维数对形式表示的，如何把 LIS 算法运用过来呢？
 *
 *  这道题的解法是比较巧妙的：
 *
 * 先对宽度 w 进行升序排序，如果遇到 w 相同的情况，则按照高度 h 降序排序。之后把所有的 h 作为一个数组，在这个数组上计算 LIS 的长度就是答案。
 *
 * 这个解法的关键在于，对于宽度 w 相同的数对，要对其高度 h 进行降序排序。因为两个宽度相同的信封不能相互包含的，逆序排序保证在 w 相同的数对中最多只选取一个。
 *
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes){
        int max = 0;
        int dp[] = new int[envelopes.length];
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });

        for(int[] env : envelopes){
            int left = 0, right = max;
            while(left < right){
                int mid = (left + right) / 2;
                if(dp[mid] < env[1]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            dp[left] = env[1];
            if(left == max) {
                max++;
            }
        }
        return max;

/*
    下面的代码逻辑等同于上面的查找最长升序子序列
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            // 要处理的扑克牌
            int poker = nums[i];
            int left = 0, right = piles;
            // 二分查找插入位置
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker)
                    right = mid;
                else
                    left = mid + 1;
            }
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
*/

    }
}
