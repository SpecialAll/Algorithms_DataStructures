package com.zxh.leetcode.exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/19
 */

/**
 * 最长回文子串
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(chars[i])){
                int temp = map.get(chars[i]);
                map.put(chars[i], ++temp);
            } else {
                map.put(chars[i], 1);
            }
        }
        int ans = 0;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> entry = (Map.Entry) iterator.next();
            int temp = entry.getValue();
            ans += temp/2*2;
            if(temp%2 == 1 && ans%2 == 0){
                ans ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
