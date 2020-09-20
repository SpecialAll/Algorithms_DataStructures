package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.TreeNode;

/**
 * @Author: ningque
 * @Date: 2020/9/17
 * @Version 1.0
 */
public class KthNode {
    /**
     * 题目描述
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
     */
    int index = 0;
    TreeNode temp;
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null)
            return null;
        index = k;
        return KNode(pRoot);
    }
    public TreeNode KNode(TreeNode node){

        if(node != null){
            KNode(node.left);
            if(index == 1){
                temp = node;
            }
            index--;
            KNode(node.right);
        }
        return temp;
    }
}
