package com.zxh.leetcode.tencent;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution148 {
    public ListNode sortList(ListNode head) {
        //使用归并排序思想
        return head  == null ? null : mergeSort(head);
    }
    private ListNode mergeSort(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode p = head, q = head, pre = null;
        while(q != null && q.next != null){
            pre = p;
            p = p.next;
            q = q.next.next;
        }

        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);
        return merge(l,r);
    }

    ListNode merge(ListNode l, ListNode r){
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while(l != null && r != null){
            if(l.val <= r.val){
                cur.next = l;
                cur = cur.next;
                l = l.next;
            }else{
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if(l != null){
            cur.next = l;
        }
        if(r != null){
            cur.next = r;
        }
        return ans.next;
    }

}

public class SortList {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new Solution148().sortList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
