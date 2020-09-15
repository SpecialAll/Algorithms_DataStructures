package com.zxh.leetcode.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: ningque
 * @Date: 2020/9/15
 * @Version 1.0
 */
public class FindAnagrams {
    public static void main(String[] args) {

    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s == null || p == null) {
            return ans;
        }
        int len1 = s.length();
        int len2 = p.length();
        if(len1 < len2) {
            return ans;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(int i=0; i<len2; i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int vaild = len2;
        int low = 0, high = 0;
        while(high < len1){
            char ch = s.charAt(high);
            if(map.containsKey(ch)){
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch) <= map.get(ch)){
                    vaild--;
                }
            }
            // 如果valid为0，则代表完全匹配
            while (vaild == 0){
                if(high - low + 1 == len2){
                    ans.add(low);
                }
                char c = s.charAt(low);
                if(map.containsKey(c)){
                    window.put(c, window.get(c) - 1);
                    if(window.get(c) < map.get(c)){
                        vaild++;
                    }
                }
                low++;
            }
            high++;
        }
        return ans;
    }
}
