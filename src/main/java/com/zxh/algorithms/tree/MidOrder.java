package com.zxh.algorithms.tree;

import com.zxh.leetcode.tencent.TreeNode;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 *
 * 二叉树中序遍历
 */
public class MidOrder {
    ArrayList<TreeNode> list = new ArrayList<>();
    /**
     * 采用递归实现中序遍历
     */
    public void midOrder(TreeNode root){
        if(root == null)
            return;
        midOrder(root.left);
        list.add(root);
        midOrder(root.right);
    }

    /**
     * 采用非递归方式实现中序遍历
     */
    public void midOrder2(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                list.add(root);
                root = root.right;
            }
        }
    }
}
