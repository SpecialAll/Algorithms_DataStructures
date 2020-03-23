package com.zxh.nowCoder.jianzhi_offer;

import java.util.Scanner;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/19
 */
public class StrToInt {
    public static int StrToInt(String str) {
        if(str.length() == 0)
            return 0;
        char[] chars = str.toCharArray();
        long ans = 0;
        int len = chars.length;
        int flag = 1;
        if(chars[0] == '+'){
            flag = 1;
            for(int i=1; i<len; i++){
                if(chars[i] < '9' && chars[i] > '0'){
                    ans += (chars[i] - '0')*Math.pow(10,len-i-1);
                }
            }
        } else if(chars[0] == '0'){
            return 0;
        } else if(chars[0] == '-'){
            flag = 2;
            for(int i=1; i<len; i++){
                if(chars[i] < '9' && chars[i] > '0'){
                    ans += (chars[i] - '0')*Math.pow(10,len-i-1);
                }
            }
        }else {
            for(int i=0; i<len; i++){
                if(chars[i] < '9' && chars[i] > '0'){
                    ans += (chars[i] - '0')*Math.pow(10,len-i-1);
                } else {
                    flag = 3;
                    break;
                }
            }
        }
        if(flag == 1){
            return (int) ans;
        } else if(flag == 2){
            return (int) (0-ans);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(StrToInt(str));
    }
}
