package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/22
 *
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 解题思路：s使用队列来求解；
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
            ans.add(node.val);
        }
        return ans;
    }
}
