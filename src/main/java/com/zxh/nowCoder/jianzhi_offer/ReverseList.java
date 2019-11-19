package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.ListNode;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/18
 *
 * 题目描述：
 *  输入一个链表，反转链表后，输出新链表的表头。
 *
 *  结题思路：
 *      看一下代码应该很好就理解吧
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode temp = null;
        while(head != null){
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
