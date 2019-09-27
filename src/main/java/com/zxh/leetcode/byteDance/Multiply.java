package com.zxh.leetcode.byteDance;

/**
 * 题目描述：
 *  给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply {
    public String multiply(String num1, String num2){
//        if(num1 == "0" || num2 == "0")
//            return "0";

        int len1 = num1.length();
        int len2 = num2.length();
        if(len1 == 1 && Integer.parseInt(num1) == 0) {
            return num1;
        }
        if(len2 == 1 && Integer.parseInt(num2) == 0) {
            return num2;
        }
        int[] ans = new int[len1+len2];
        for(int i=0; i<len1; i++){
            for(int j=0; j<len2; j++){
                ans[i+j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int flag = 0;
        String res = "";
        for(int i=len1+len2-2; i>=0; i--){
            res  = (ans[i]+flag)%10 + res;//注意这里的res是加在后面的！！！！
            flag = (flag + ans[i])/10;
        }
        if(flag > 0){
            res = flag + res; //同上
        }
        return res;
    }

    public static void main(String[] args) {
        Multiply mul = new Multiply();
        System.out.println("ans = "+mul.multiply("9133","0"));
    }
}
