package com.zxh.leetcode.TopInterview;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述：
 *
 * 题目：最长公共前缀
 *
 * 难度：EASY
 *
 * 题目内容：
 *
 * 给定一个包含2-9包含数字的字符串，返回所有可能表示的字母组合。
 *
 * 数字到字母的映射(就像电话上的按钮一样)如下所示。注意，1没有映射到任何字母。
 *
 * 解题思路：
 *  首先要知道要做什么，再思考用什么数据结构（list、栈、队列、堆、map、set），再思考用什么算法。不要冲上来就想着算法。
 *
 * 　　　　做什么，用什么做：根据输入的数字进行所有可能搭配，数据结构中每一个都要和新来的几个字符进行组合字符，
 *                         而且新来字符组合数目并不确定，
 *                         所以得采用while循环，并且每一个变成新的组合后又得回到原来的数据结构，队列结构就能完美解决。
 *
 * 　　　　怎么做：首先弄一个空队列，for对digits循环，看队头，看它的长度是否已经是 i 个（for内），
 *              是则队头出队，再取digit对应的几个字符分别加在此字符串（队头）的后面。以此类推。
 */
public class LetterCombinations {
    public List<String> getCombinations(String digits){
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty())
            return ans;
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i=0; i<digits.length(); i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length() == i){
                String t = ans.remove();
                for(char s : map[x].toCharArray()){
                    ans.add(t+s);
                }
            }
        }
        return ans;
    }
}
