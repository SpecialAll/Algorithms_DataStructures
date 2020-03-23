package com.zxh.nowCoder.jianzhi_offer;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/19
 */
public class Sum_Solution {
    //采用右移除二
    public int Sum_Solution(int n) {
        int ans;
        ans = (int)Math.pow(n, 2) + n;
        return ans>>1;
    }
    /**
     * 采用&&短路，递归运算
     * C++实现
     */
//    int Sum_Solution1(int n) {
//        int ans = n;
//        ans && (ans += Sum_Solution(n-1));
//        return ans;
//    }
}
