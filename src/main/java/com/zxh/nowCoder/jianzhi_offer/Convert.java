package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.TreeNode;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 *
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 解题思路：
 *  采用中序遍历就可以解决！！！
 */
public class Convert {
    TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode convert(TreeNode pRoot){
        convertSub(pRoot);
        return head;
    }

    private void convertSub(TreeNode root) {
        if(root == null)
            return;
        convertSub(root.left);
        if(head == null){
            head = root;
            realHead = root;
        } else {
            head.right = root;
            root.left = head;
            head = root;
        }
        convertSub(root.right);
    }
}
