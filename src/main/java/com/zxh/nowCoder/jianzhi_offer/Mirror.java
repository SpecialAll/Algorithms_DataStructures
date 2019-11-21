package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.TreeNode;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/20
 *
 * 题目描述；
 *  操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class Mirror {
    public void mirror(TreeNode root){
        //使用递归求解
        if(root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null){
            mirror(root.left);
        }
        if(root.right != null){
            mirror(root.right);
        }
    }
}
