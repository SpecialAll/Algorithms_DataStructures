package com.zxh.leetcode.byteDance;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongLengthSubString {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> pos = new HashMap<>();
        char[] ss = s.toCharArray();

        int max = 0, temp = 0;

        for (int i = 0; i < s.length(); i++) {

            if (!pos.containsKey(ss[i])) {
                pos.put(ss[i], i);
                temp++;
            } else {
                // 这里可能存在之前的字符没有判断，使用debug测试一下
                if (pos.get(ss[i]) + temp < i) {
                    temp++;
                } else {
                    max = Math.max(max, temp);
                    temp = i - pos.get(ss[i]);
                }
                pos.put(ss[i], i);
            }

        }
        max = Math.max(max, temp);
        return max;
    }

    /**
     * 打印字符串
     * @param str
     * @return
     */
    public int findString(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        int max = 0;
        int temp = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        String ans = "";
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, i);
                temp++;
            } else {
                // 代表当前统计的子串中已经存在
                if(i - map.get(ch) < temp){
                    if (max < temp){
                        max = Math.max(max, temp);
                        ans = str.substring(start, i);
                        temp = i - map.get(ch);
                        start = map.get(ch) + 1;
                    }
                } else {
                    temp++;
                }
                map.put(ch, i);
            }
        }
        if(max < temp){
            max = Math.max(max, temp);
            ans = str.substring(start);
        }
        System.out.println(ans);
        return max;
    }

    public static void main(String[] args) {
        LongLengthSubString subString = new LongLengthSubString();
        System.out.println(subString.lengthOfLongestSubstring("ababcd"));
        System.out.println(subString.findString("ababcd"));
    }
}
