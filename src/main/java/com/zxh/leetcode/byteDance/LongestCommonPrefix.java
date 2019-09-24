package com.zxh.leetcode.byteDance;

/**
 * 题目描述：
 *  编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public  String longestCommonPrefix(String[] strs){
        int len = strs.length;
        if(len == 0)
            return "";
        if(len == 1)
            return strs[0];
        StringBuilder ans = new StringBuilder();
        int length = getMinLength(strs);  //找出最小的字符串长度
        for(int i=0; i<length; i++){
            char s = strs[0].charAt(i);
            for(int j=1; j<len; j++){
                if(strs[j].charAt(i) != s){
                    return ans.toString();
                }
            }
            ans.append(s);
        }
        return ans.toString();
    }
    public int getMinLength(String[] strs){
        int temp = strs[0].length();
        for (String str : strs) {
            if(temp > str.length()){
                temp = str.length();
            }
        }
        return temp;
    }
}
