package com.zxh.leetcode.byteDance;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * 解题思路：
 *  使用一个栈，每次存入元素时，存入两个数字（插入数字和当前栈中的最小数字），
 *  也就是说需要2n个位置来存储n个数字！！！
 */
public class MinStack {

    Stack<Integer> stack = null;
    public MinStack(){
        stack = new Stack<>();
    }

    //push操作
    public void push(int x){
        if(stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else{
            int temp = stack.peek();
            stack.push(x);
            if(temp < x)
                stack.push(temp);
            else
                stack.push(x);
        }
    }

    //pop操作
    public void pop(){
        stack.pop();
        stack.pop();
    }

    //top操作
    public int top(){
        return stack.get(stack.size()-2);
    }

    //getMin操作
    public int getMin(){
        return stack.peek();
    }
}
