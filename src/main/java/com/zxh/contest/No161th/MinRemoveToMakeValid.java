package com.zxh.contest.No161th;

import java.util.Stack;

/**
 * 题目描述：
 *   给你一个由 '('、')' 和小写字母组成的字符串 s。
 *
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 *
 * 请返回任意一个合法字符串。
 *
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 *
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 *
 *
 * 示例 1：
 *
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * 示例 2：
 *
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 *
 *
 * 题目解析：
 *  移除无效的括号\rightarrow→通过栈实现
 * 我们可以使用一个栈存储括号，一个StringBuilder进行字符串重组，其具体思路为：
 * 扫描字符串，分类讨论：
 *      如果字符为小写字母，直接加入StringBuilder
 *      如果字符为左括号，入栈，加入StringBuilder
 *      如果字符为右括号：
 *          如果栈为空，该右括号一定非法，不加入
 *          如果栈不为空，栈顶一定为左括号，栈顶出栈，将右括号加入StringBuilder
 *      扫描结束后：
 *          如果栈不为空，栈中一定全部是非法的左括号。假设此时栈大小为kk，从后向前删除kk个左括号即可
 *          如果栈为空，说明字符串本身合法
 * 将StringBuilder转换为字符串，返回
 *
 */
public class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            if(temp >= 97){
                sb.append(temp);
            }else if(temp == '('){
                sb.append(temp);
                stack.push(temp);
            }else {
                if(!stack.isEmpty()){
                    stack.pop();
                    sb.append(temp);
                }else
                    continue;
            }
        }
        for(int i=0; i<stack.size(); i++){
            sb.deleteCharAt(sb.lastIndexOf("("));
        }
        return sb.toString();
    }
}
