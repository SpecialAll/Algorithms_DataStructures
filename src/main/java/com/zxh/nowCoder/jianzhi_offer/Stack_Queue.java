package com.zxh.nowCoder.jianzhi_offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 *
 */
public class Stack_Queue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    //栈1做入队列，栈2做出队列
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int ans = stack2.pop();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return ans;
    }
}
