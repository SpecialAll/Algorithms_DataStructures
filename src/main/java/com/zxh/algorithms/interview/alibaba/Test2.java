package com.zxh.algorithms.interview.alibaba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/20
 */
public class Test2 {
    /**
     * 测试用例：
     * 4
     * aaa
     * bcd
     * zzz
     * bcdef
     *
     * 答案输出：
     * 11
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1){
            System.out.println(sc.nextLine());
            return;
        }
        //list存储输入的字符串
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(sc.next());
        }

        Collections.sort(list);

//        int ans = longestlength(list);
        int ans = longestlength2(list);
        System.out.println(ans);

    }

    /**
     * 获取最长字符串长度
     * @param list  所有输入的字符串
     * @return      返回int类型的长度
     */
    private static int longestlength(ArrayList<String> list){
        //记录返回长度
        int ans = list.get(0).length();
        String str;
        String temp = list.get(0);
        for(int j=1; j<list.size(); j++){
            str = list.get(j);
            //比较当前字符串最后一个字符和下一个字符串第一个字符，以确保递增
            if(temp.charAt(temp.length()-1) <= str.charAt(0)){
                ans += str.length();
                temp = str;
            } else {
                if(temp.length() < str.length()){
                    ans -= temp.length();
                    ans += str.length();
                    temp = str;
                }
            }
        }
        return ans;
    }

    /**
     * 使用ＤＰ进行求解，dp[i] = string.length;
     * @param list
     * @return
     */
    private static int longestlength2(ArrayList<String> list){
        int[] dp = new int[list.size()];
        String temp,str ;
        for(int i=list.size()-1; i>=0; i--){
            temp = list.get(i);
            for(int j=i; j<list.size(); j++){
                str = list.get(j);
                if(i == j){
                    dp[i] = temp.length();
                }
                /**
                 * 注意这里的条件判断，当ｉ　＝＝　j时
                 * 测试用例：4
                 * aaa
                 * bcd
                 * zzz
                 * bcdef
                 *
                 * ｄｐ初始化过程中，第一步执行zzz, 此时若没有 i!=j 的判断，则会进入该if条件句，导致dp[3] = 6，结果错误！！！
                 *
                 */
                if(temp.charAt(temp.length() - 1) <= str.charAt(0) && i != j){
                    dp[i] = Math.max(temp.length() + dp[j], dp[i]);
                }
            }
        }
        return dp[0];
    }
}
