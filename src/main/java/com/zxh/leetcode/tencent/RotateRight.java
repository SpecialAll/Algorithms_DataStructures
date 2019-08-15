package com.zxh.leetcode.tencent;

/**
 * 题目描述：
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 解题思路：
 *
 * 思路一：说是循环旋转，但其实本质上是将尾部向前数第K个元素作为头，原来的头接到原来的尾上
 *
 * 思路二：链表中的点已经相连，一次旋转操作意味着：
 *
 *    先将链表闭合成环
 *    找到相应的位置断开这个环，确定新的链表头和链表尾

     算法实现很直接：

     找到旧的尾部并将其与链表头相连 old_tail.next = head，整个链表闭合成环，同时计算出链表的长度 n。
     找到新的尾部，第 (n - k % n - 1) 个节点 ，新的链表头是第 (n - k % n) 个节点。
     断开环 new_tail.next = None，并返回新的链表头 new_head。

 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        ListNode old_tail = head;
        int n = 1;
        while(old_tail.next != null){
            old_tail = old_tail.next;
            n++;
        }
        old_tail.next = head;

        ListNode new_tail = head;
        for(int i=0; i < n - k%n -1; i++){
            new_tail = new_tail.next;
        }
        ListNode newList = new_tail.next;

        new_tail.next = null;
        return newList;

    }
}
