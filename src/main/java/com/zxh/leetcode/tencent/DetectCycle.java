package com.zxh.leetcode.tencent;

/**
 * 题目描述：
 *  给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 解题思路：
 *      分两个步骤，首先通过快慢指针的方法判断链表是否有环；
 *      接下来如果有环，则寻找入环的第一个节点。具体的方法为，首先假定链表起点到入环的第一个节点A的长度为a【未知】，到快慢指针相遇的节点B的长度为（a + b）【这个长度是已知的】。
 *      现在我们想知道a的值，注意到快指针p2始终是慢指针p走过长度的2倍，所以慢指针p从B继续走（a + b）又能回到B点，如果只走a个长度就能回到节点A。但是a的值是不知道的，
 *      解决思路是曲线救国，注意到起点到A的长度是a，那么可以用一个从起点开始的新指针q和从节点B开始的慢指针p同步走，相遇的地方必然是入环的第一个节点A。
 *      文字有点绕，画个图就一目了然了~~
 *
 *      假设环内剩余长度为c,则快指针走过的长度为: 2(a+b) = a + b + c + b 所以c=a
 *
 *      画图理解！！！！！！
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        //采用快慢指针找到链表是否有环
        ListNode p = head, q = head;
        boolean isCycle = false;
        while(q != null && q.next != null){
            //注意这里的空指针异常！！！！while (p.next != null && q.next.next != null)
            p = p.next;
            q = q.next.next;
            if(p == q){
                isCycle = true;
                break;
            }
        }

        //如果有环的话，找到入环的节点
        if(isCycle){
            ListNode p1 = head;
            while(p1 != q){
                p1 = p1.next;
                q = q.next;
            }
            return q;
        }else{
            return null;
        }
    }
}
