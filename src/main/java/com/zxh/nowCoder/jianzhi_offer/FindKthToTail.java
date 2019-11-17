package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.ListNode;

import java.util.Stack;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/17
 *
 * 题目描述：
 *  输入一个链表，输出该链表中倒数第k个结点。
 *
 *  注意一些临界条件！！！
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null || k ==0)
            return null;
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.add(head);
            head = head.next;
        }
        ListNode ans = new ListNode(0);
        while(k>1 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        if(stack.isEmpty())
            return null;
        return stack.pop();
    }
}
