package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: ningque
 * @Date: 2020/9/17
 * @Version 1.0
 */
public class IsSymmetrical {
    /**
     * 题目描述
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     *
     */
    public static void main(String[] args) {
        Deque<TreeNode> queue = new LinkedList<>();

    }
    public boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null)
            return true;;
        return judge(pRoot, pRoot);
    }
    public boolean judge(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        } else if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        } else {
            return judge(root1.left, root2.right) && judge(root1.right, root2.left);
        }
    }

}
