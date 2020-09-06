package com.zxh.labuladong;

/**
 * 题目描述：
 *  给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 *
 */

/**
 * @Author: ningque
 * @Date: 2020/8/26
 * @Version 1.0
 */
public class MinDistance {

    /**
     * 两个字符串都从末端开始遍历，如果两个位置的字符一样就不用做如何操作
     *
     * 伪代码：
     * if s1【i】 == s2[j]
     *    skip;
     * else
     *    三种操作
     *    删除
     *    替换
     *    添加
     *
     */
    public int minDistance(String str1, String str2) {
        // 转换为char数组
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        //使用dp求解
        int len1 = str1.length();
        int len2 = str2.length();

        // 建立dp数组
        int[][] dp = new int[len1+1][len2+1];

        // 如果第二个字符串为空，则删除第二个字符串
        for (int i=1; i<=len1; i++) {
            dp[i][0] = i;
        }
        // 如果第一个字符串为空，则将第二个字符串添加进来
        for (int j=1; j<=len2; j++) {
            dp[0][j] = j;
        }

        for (int i=0; i<len1; i++) {
            for (int j=0; j<len2; j++) {
                // 如果字符串相等则跳过
                if (ch1[i] == ch2[j]) {
                    dp[i+1][j+1] = dp[i][j];
                    continue;
                }

                // 如果不相等存在三种可能的操作，删除、替换、插入
                int delete = dp[i+1][j] + 1;
                int insert = dp[i][j+1] + 1;
                int replace = dp[i][j] + 1;
                // 找出最小的操作数
                dp[i+1][j+1] = Math.min(Math.min(delete, insert), replace);
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String str1 = "ros";
        String str2 = "horse";
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance(str1, str2));
    }
}
