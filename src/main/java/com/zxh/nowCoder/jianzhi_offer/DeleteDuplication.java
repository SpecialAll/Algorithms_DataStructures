package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.ListNode;

/**
 * @Author: ningque
 * @Date: 2020/9/16
 * @Version 1.0
 */
public class DeleteDuplication {
    /**
     * 题目描述
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */
    public static void main(String[] args) {

    }
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode ans = new ListNode(0);
        ans.next = pHead;
        ListNode pre = ans;
        ListNode cur = ans.next;
        while (cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return  ans.next;
    }

    /**
     * 递归：
     * 1.特殊情况，头节点为null或头节点下一节点为null，直接返回头节点，这时不存在重复节点
     * 2.如果头节点与，头节点的下一节点值相等，跳过所有相等节点。递归调用函数判断最后一个跳过节点的后一节点。
     * 3.如果头节点与，头节点的下一节点值不等，递归调用函数判断头节点的后一节点。
     *
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

}
