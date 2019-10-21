package com.zxh.leetcode.byteDance;

import com.zxh.leetcode.tencent.ListNode;

/**
 * 题目描述：
 *  合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {
    public ListNode  mergeKLists(ListNode[] lists){
        if(lists == null || lists.length == 0)
            return null;
        return merge(lists, 0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if(start == end)
            return lists[start];
        int mid = start + (end - start)/2;
        ListNode l1 = merge(lists, start, mid);
        ListNode l2 = merge(lists, mid+1, end);
        return mergeTwoList(l1, l2);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
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
