package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/3
 *
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {

    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        /**
         * count代表本层已经遍历的节点数
         * nextCount 代表本层的节点数
         * depth 代表深度
         */

        int count = 0, nextCount = 1, depth = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            count++;
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
            if(count == nextCount){
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }


    /**
     * 递归求解
     * @param root
     * @return
     */
    public int TreeDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = TreeDepth1(root.left) + 1;
        int right = TreeDepth1(root.right) + 1;
        return Math.max(left, right);
    }
}
