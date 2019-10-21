package com.zxh.leetcode.byteDance;

import com.zxh.leetcode.tencent.ListNode;

/**
 * 题目描述：
 *  编写一个程序，找到两个单链表相交的起始节点。
 *
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode pa = headA, pb = headB;
        while(pa != pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
