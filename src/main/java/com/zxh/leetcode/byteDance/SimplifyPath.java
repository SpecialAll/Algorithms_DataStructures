package com.zxh.leetcode.byteDance;

import java.util.Stack;

/**
 * 题目描述：
 *  请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 *
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 示例 3：
 *
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 *
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 示例 5：
 *
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 示例 6：
 *
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 *
 * 解决思路：
 *  1、首先考虑使用哪种数据类型比较合适，因为是路径简化，所以采用栈解决该问题是最合适的；
 *  2、其次我们需要将传入的字符串分割，进行逻辑判断拼接；
 */
public class SimplifyPath {
    public String simplifyPath(String path){
        Stack<String> stringStack = new Stack<>();
        String[] arr = path.split("/");
        for(String str : arr ){
            if(str.equals("") || str.equals("."))
                continue;
            if(str.equals("..")){
                if(!stringStack.empty()){
                    stringStack.pop();
                }
            }
            else
                stringStack.push(str);
        }
        String ans = "";
        while(!stringStack.empty()){
            ans = "/" + stringStack.pop() + ans;
        }
        if(ans.equals(""))
            return "/";
        return ans;
    }
}
