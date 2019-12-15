package com.zxh.nowCoder.jianzhi_offer;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/10
 *
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    public String LeftRotateString(String str, int n){
        if(str.length() == 0)
            return "";
        /**
         * 这里有点问题，应该需要注意到n大于str长度的情况，也就是循环的情况，
         * 但是在牛客上没有考虑到！
         */
        while(n>str.length())
            n = n-str.length();
        StringBuilder sb = new StringBuilder();
        String temp = str.substring(0,n);
        char[] ch = str.toCharArray();
        for(int i=n; i<str.length(); i++){
            sb.append(ch[i]);
        }
        sb.append(temp);
        return sb.toString();
    }

    public static void main(String[] args) {
        LeftRotateString leftRotateString = new LeftRotateString();
        System.out.println(leftRotateString.LeftRotateString("ab",6));
    }
}
