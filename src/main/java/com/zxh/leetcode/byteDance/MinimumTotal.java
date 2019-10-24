package com.zxh.leetcode.byteDance;

import java.util.List;

/**
 * 题目描述：
 *  给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 *
 * 解题思路：
 *  采用动态规划算法，从三角形底部开始，每一层数字遍历时，加上上一层的左右两个相邻数字中的最小值！！！！则最后的就是答案；
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle){
        int rows = triangle.size();
        int[] temp = new int[rows+1];
        for(int row = rows-1; row>=0; row--){
            for(int i=0; i<=row; row++){
                temp[i] = Math.min(temp[i], temp[i+1]) + triangle.get(row).get(i);
            }
        }
        return temp[0];
    }
}
