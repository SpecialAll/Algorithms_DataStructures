package com.zxh.algorithms.interview.meituan;

import java.util.Scanner;

/**
 * @Author: ningque
 * @Date: 2020/9/27
 * @Version 1.0
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        int[] dp = new int[len];
        getMax(str, dp);
        int max = 0;
        for(int i=0 ;i<len; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
    public static void getMax(String str, int[] dp){
        char[] ch = str.toCharArray();
        if(ch[0] == 'E'){
            dp[0] = 1;
        }
        for(int i=1; i<ch.length; i++){
            if(ch[i] == 'E'){
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = dp[i-1] - 1;
            }
        }
    }
}
