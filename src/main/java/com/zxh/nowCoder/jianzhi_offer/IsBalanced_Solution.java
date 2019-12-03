package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.TreeNode;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/3
 *
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 思路：
 * 通过平衡二叉树的特点。左右子树的高度差不超过1
 */
public class IsBalanced_Solution {
    /**
     * 从低到上依次遍历，如果下层二叉树是平衡的则返回树的高度，如果不是平衡的则终止遍历！
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return TreeDepth1(root) != -1;
    }
    public int TreeDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = TreeDepth1(root.left);
        //这里的判断是 如果该层是不平衡的则直接返回-1
        if(left == -1)
            return -1;
        int right = TreeDepth1(root.right);
        if(right == -1)
            return -1;
        return Math.abs(left - right) > 1 ? -1 : 1+Math.max(left, right);
    }
}
