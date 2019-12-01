package com.zxh.nowCoder.jianzhi_offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/1
 *
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * 解题思路：关键是在于LinkedHashMap的使用，因为它可保证输入输出顺序是一致的；
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        char[] arr = str.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int ans = -1;
        for(int i=0; i<arr.length; i++){
            char temp = arr[i];
            if(map.get(temp) == 1){
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar repeatingChar = new FirstNotRepeatingChar();
        System.out.println(repeatingChar.FirstNotRepeatingChar("google"));
    }
}

