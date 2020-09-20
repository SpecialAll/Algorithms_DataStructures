package com.zxh.nowCoder.jianzhi_offer;

/**
 * @Author: ningque
 * @Date: 2020/9/17
 * @Version 1.0
 */
public class CutRope {
    /**
     * 题目描述
     * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
     * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     */
    public int cutRope(int n){
        // n<=3的情况，m>1必须要分段，例如：3必须分成1、2；1、1、1 ，n=3最大分段乘积是2,
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] =3;
        // res记录最大值
        int res = 0;
        for(int i=4; i<=n; i++){
            for(int j=1; j<=i/2; j++){
                res = Math.max(res, dp[j]*dp[i-j]);
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
