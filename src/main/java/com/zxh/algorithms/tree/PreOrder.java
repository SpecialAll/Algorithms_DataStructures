package com.zxh.algorithms.tree;

import com.zxh.leetcode.tencent.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 *
 * 二叉树的前序遍历
 */
public class PreOrder {
    /**
     * 递归实现
     */
    ArrayList list = new ArrayList();
    public void preOrder1(TreeNode root){
        if(root == null)
            return;
        list.add(root.val);
        preOrder1(root.left);
        preOrder1(root.right);
    }

    /**
     * 非递归实现:使用栈的数据结构，每次压栈直至节点为空，压栈进入的数字便是每次遍历的数字
     */
    public void preOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while(root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                //当栈不为空时，取出栈顶元素遍历其右子树
                root = stack.pop();
                root = root.right;
            }
        }
    }
}
