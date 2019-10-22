package com.zxh.leetcode.byteDance;

import com.zxh.leetcode.tencent.TreeNode;

import java.util.*;

/**
 * 题目描述：
 *  给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 解题思路：
 *  区分奇偶深度的不同！！！！！
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cnt = queue.size();
            for(int i=0; i<cnt; i++){
                TreeNode node = queue.poll();
                if(depth%2 == 0)
                    temp.add(node.val);
                else
                    temp.add(0,node.val); //注意第一层的深度为0！！！！！
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            res.add(temp);
            depth++;
        }
        return res;
    }

}
