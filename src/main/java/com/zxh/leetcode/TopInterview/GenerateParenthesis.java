package com.zxh.leetcode.TopInterview;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述：
 *  给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 解题思路：
 *
 *  本题最核心的思想是，考虑 i=n 时相比 n-1 组括号增加的那一组括号的位置。
 *
 *  采用动态规划的思路，将n组括号看成n-1组合当前添加组的关系；
 *  也就是添加一个新括号时，仅仅存在两种情况，一种是在当前括号左边，一种是在当前括号右边；
 *
 *  当我们清楚所有 i<n 时括号的可能生成排列后，对与 i=n 的情况，我们考虑整个括号排列中最左边的括号。
 * 它一定是一个左括号，那么它可以和它对应的右括号组成一组完整的括号 "( )"，我们认为这一组是相比 n-1 增加进来的括号。
 *
 * 那么，剩下 n-1 组括号有可能在哪呢？
 *
 * 【这里是重点，请着重理解】
 *
 * 剩下的括号要么在这一组新增的括号内部，要么在这一组新增括号的外部（右侧）。
 *
 * 既然知道了 i<n 的情况，那我们就可以对所有情况进行遍历：
 *
 * "(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
 *
 * 其中 p + q = n-1，且 p q 均为非负整数。
 *
 * 事实上，当上述 p 从 0 取到 n-1，q 从 n-1 取到 0 后，所有情况就遍历完了。
 *
 * 注：上述遍历是没有重复情况出现的，即当 (p1,q1)≠(p2,q2) 时，按上述方式取的括号组合一定不同。
 *
 *
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n){
        LinkedList<LinkedList<String>> ans = new LinkedList<LinkedList<String>>();
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("");
        ans.add(list1);
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("()");
        ans.add(list2);
        for(int i=2; i<=n; i++){
            LinkedList<String> temp = new LinkedList<>();
            for(int j=0; j<i; j++){
                LinkedList<String> str1 = ans.get(j);
                LinkedList<String> str2 = ans.get(i-1-j);
                for(String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }
            }
            ans.add(temp);
        }
        return ans.get(n);
    }
}
