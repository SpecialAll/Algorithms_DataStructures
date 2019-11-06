package com.zxh.nowCoder.byteDance_2019_spring;

import java.util.Scanner;

/**
 * 题目描述:
 *  1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 *
 */
public class Main_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        while(num > 0){
            char[] arrays = sc.nextLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char c : arrays){
                if(sb.length() < 2){
                    sb.append(c);
                    continue;
                }
                if(sb.length() >= 2){
                    if(sb.charAt(sb.length()-1) == c && sb.charAt(sb.length()-2) == c)
                        continue;
                }
                if(sb.length() >= 3){
                    if(sb.charAt(sb.length()-2) == sb.charAt(sb.length()-3) && c == sb.charAt(sb.length()-1))
                        continue;
                }
                sb.append(c);
            }
            System.out.println(sb);
            num--;
        }
    }
}
