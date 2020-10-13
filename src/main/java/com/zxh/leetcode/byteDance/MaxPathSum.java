package com.zxh.leetcode.byteDance;

import com.zxh.leetcode.tencent.TreeNode;

/**
 * @Author: ningque
 * @Date: 2020/9/27
 * @Version 1.0
 */
public class MaxPathSum {
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {

    }
    public static int pathSum(TreeNode root){
        if(root == null)
            return 0;
        int left = Math.max(pathSum(root.left), 0);
        int right = Math.max(pathSum(root.right), 0);
        int value = left + right + root.val;
        max = Math.max(max, value);
        return root.val + Math.max(left, right);
    }
}
