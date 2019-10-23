package com.zxh.leetcode.byteDance;

/**
 * 题目描述：
 *  在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * 解题思路：
 *  动态规划！！！！
 */
public class MaximalSquare {
    //方法一
    public  int maximalSquare(char[][] matrix){
        int rows = matrix.length , cols = rows > 0 ? matrix[0].length : 0;
        int dp[] = new int[cols+1];
        int maxlen = 0, pre = 0;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=cols; j++){
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(Math.min(dp[j-1], pre),dp[j]) + 1;
                    maxlen = Math.max(maxlen, dp[j]);
                }else{
                    dp[j] = 0;
                }
                pre = temp;
            }
        }
        return maxlen*maxlen;
    }

    //方法二
    public int maximalSquare2(char[][] matrix) {
        int rows = matrix.length , cols = rows > 0 ? matrix[0].length : 0;
        int dp[][] = new int[rows+1][cols+1];
        int maxlen = 0;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=cols; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]) + 1;
                    maxlen = Math.max(maxlen, dp[i][j]);
                }
            }
        }
        return maxlen*maxlen;
    }
}
