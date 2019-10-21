package com.zxh.leetcode.byteDance;

import com.zxh.leetcode.tencent.ListNode;

/**
 * 题目描述：
 *  将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        while(l1 != null || l2 != null){
            if(l1.val <= l2.val){
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }else{
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if(l1 != null){
            temp.next = l1;
        }else{
            temp.next = l2;
        }
        return ans.next;
    }
    /**
     * 第二种解法！！！
     */
    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }
}
