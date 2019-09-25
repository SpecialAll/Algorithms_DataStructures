package com.zxh.leetcode.byteDance;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 *  给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 解题思路：
 *  采用滑动窗口的思路，以第一个字符串的长度为滑动窗口大小！！！
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2){
        if(s1.length() > s2.length())
            return false;
        int len = s1.length();
        char[] s = s2.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<len; i++){
            addCharacter(map1, s1.charAt(i));
            addCharacter(map2, s[i]);
        }
        int temp = 0;
        while(true){
            if(map1.equals(map2))
                return true;
            if(len == s2.length())
                return false;
            addCharacter(map2, s[len++]);
            popCharacter(map2, s[temp]);
            temp++;
        }
    }
    public void addCharacter(Map<Character, Integer> map, char ch){
        if(map.containsKey(ch)){
            map.put(ch, map.get(ch)+1);
        }else{
            map.put(ch, 1);
        }
    }
    public void popCharacter(Map<Character, Integer> map, char ch){
        if(map.containsKey(ch)){
            if(map.get(ch) == 0){
                map.remove(ch);
            }else{
                map.put(ch, map.get(ch)-1);
            }
        }else {
            map.put(ch, -1);
        }
    }
}
