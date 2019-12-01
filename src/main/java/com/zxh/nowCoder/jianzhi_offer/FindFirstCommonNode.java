package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.ListNode;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/1
 *
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        用两个指针扫描”两个链表“，最终两个指针到达 null 或者到达公共结点。
//        长度相同有公共结点，第一次就遍历到；没有公共结点，走到尾部NULL相遇，返回NULL
//        长度不同有公共结点，第一遍差值就出来了，第二遍一起到公共结点；没有公共，一起到结尾NULL。
        ListNode t1 = pHead1;
        ListNode t2 = pHead2;
        while(t1 != t2){
            t1 = (t1 == null ? pHead2 : t1.next);
            t2 = (t2 == null ? pHead1 : t2.next);
        }
        return t1;
    }
}
