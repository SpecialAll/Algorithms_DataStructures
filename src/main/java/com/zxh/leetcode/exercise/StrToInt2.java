package com.zxh.leetcode.exercise;

/**
 * @Author: ningque
 * @Date: 2020/9/15
 * @Version 1.0
 */
public class StrToInt2  {
    public static void main(String[] args) {
        String str = "-91283472332";
        String str2 = "3.14159";
        String str3 = "+-2";
        String str4 = " +0 123";
        String str5 = "2147483646";
        String str6 = "2147483648";
        System.out.println(strToInt(str6));
    }
    public static int strToInt(String str) {
        char[] chs = str.toCharArray();
        if(chs[0] >= 'a' && chs[0] <= 'z'){
            return 0;
        }

        // 标示正负
        int flag = 0;
        int i = 0;
        int ans = 0;
        while(i<str.length()) {
            if(chs[i] == ' ' && flag == 0){
                i++;
                continue;
            }
            if(chs[i] == '-' && flag == 0) {
                flag = -1;
                i++;
                continue;
            }
            if(chs[i] == '+' && flag == 0){
                flag = 1;
                i++;
                continue;
            }
            if(chs[i] >= 'a' && chs[i] <= 'z') {
                break;
            }
            if(chs[i] >= '0' && chs[i] <= '9'){
                if(ans > Integer.MAX_VALUE/10 && flag == -1){
                    ans = Integer.MIN_VALUE;
                    break;
                } else if(ans > Integer.MAX_VALUE / 10){
                    ans = Integer.MAX_VALUE;
                    break;
                } else if( ans == Integer.MAX_VALUE/10 && chs[i] > '7' && flag != -1){
                    ans = Integer.MAX_VALUE;
                    break;
                }
                ans = ans*10 + (chs[i] - '0');
                i++;
            } else {
                break;
            }

        }

        if(flag == -1){
            return 0-ans;
        } else {
            return ans;
        }

    }
}