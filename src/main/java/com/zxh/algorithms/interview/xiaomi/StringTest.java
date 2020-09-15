package com.zxh.algorithms.interview.xiaomi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: ningque
 * @Date: 2020/9/15
 * @Version 1.0
 */
public class StringTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<Character> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(!ans.contains(ch)){
                ans.add(ch);
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());

    }
}
