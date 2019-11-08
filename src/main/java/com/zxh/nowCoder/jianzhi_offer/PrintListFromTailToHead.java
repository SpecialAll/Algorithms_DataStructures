package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        ListNode node = listNode;
        while(node != null){
            list.add(node.val);
            node = node.next;
        }
        Collections.reverse(list);
        return list;
    }
}
