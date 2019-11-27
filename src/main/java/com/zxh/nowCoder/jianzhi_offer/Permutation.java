package com.zxh.nowCoder.jianzhi_offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/27
 *
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * 解题思路：
 *  采用回溯法求解！！！
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if(str != null && str.length() != 0){
            backtrack(str.toCharArray(), 0, ans, str.length()-1);
            Collections.sort(ans);
        }
        return ans;
    }
    public void backtrack(char[] s, int start, ArrayList<String> ans, int length){
        if(start == length){
            String temp = String.valueOf(s);
            if(!ans.contains(temp))
                ans.add(temp);
        } else {
            for(int i = start; i <= length; i++){
                swap(s, start, i);
                backtrack(s, start+1, ans, length);
                swap(s, start, i);
            }
        }
    }
    public void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;

    }
}
