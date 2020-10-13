package com.zxh.leetcode.byteDance;

/**
 * @Author: ningque
 * @Date: 2020/9/27
 * @Version 1.0
 */
public class FN {
    public static void main(String[] args) {
        /**
         * 这道题目跟 leetcode 上的不一样，leetcode 上只要求整数，这个还有精度） 写一个函数，求平方根，
         * 函数参数为目标数字和精度，测试案例 fn(4.1,0.001) fn(501.1,0.001) fn(0.045,0.001)
         */
    }
    public float fn(float n, float e){
        // 先求精度
        String s = String.valueOf(e);
        int len = s.length();
        float ans = 0;
        if(n > 0 && e > 0){
            float low = 0;
            float high = n;
            while(low < high){
                float mid = Float.parseFloat(String.format("%."+ len + "f", (low + high)/2));
                if(mid * mid < n - e){
                    low++;
                } else if(mid * mid > n + e){
                    high--;
                } else {
                    ans = mid;
                    break;
                }
            }
        }
        return ans;
    }
}
