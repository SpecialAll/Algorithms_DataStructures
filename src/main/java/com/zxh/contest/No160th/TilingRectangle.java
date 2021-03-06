package com.zxh.contest.No160th;

/**
 * 题目描述：
 *  你是一位施工队的工长，根据设计师的要求准备为一套设计风格独特的房子进行室内装修。
 *
 * 房子的客厅大小为 n x m，为保持极简的风格，需要使用尽可能少的 正方形 瓷砖来铺盖地面。
 *
 * 假设正方形瓷砖的规格不限，边长都是整数。
 *
 * 请你帮设计师计算一下，最少需要用到多少块方形瓷砖？

 * 输入：n = 2, m = 3
 * 输出：3
 * 解释：3 块地砖就可以铺满卧室。
 *      2 块 1x1 地砖
 *      1 块 2x2 地砖
 * 示例 2：
 *
 * 输入：n = 5, m = 8
 * 输出：5
 * 示例 3：
 *
 * 输入：n = 11, m = 13
 * 输出：6
 *
 * 提示：
 * 1 <= n <= 13
 * 1 <= m <= 13
 */
public class TilingRectangle {
    public int tilingRectangle(int n, int m) {
        int[][] dp=new int[15][15];

        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++) {
                dp[i][j]=i==j?1:i*j;
                for(int p=1;p<i;p++)
                    dp[i][j]=Math.min(dp[i][j], dp[p][j]+dp[i-p][j]);
                for(int p=1;p<j;p++)
                    dp[i][j]=Math.min(dp[i][j], dp[i][p]+dp[i][j-p]);
                for(int x=2;x<i;x++)
                    for(int y=2;y<j;y++)
                        dp[i][j]=Math.min(dp[i][j], dp[x-1][y]+dp[x][j-y]+dp[i-x+1][y-1]+dp[i-x][j-y+1]+1);
            }
        return dp[n][m];


    }
}
