package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.TreeNode;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 思路：
 *  使用前序和中序遍历可以确认唯一的二叉树，通过前序可以得知根节点为1，然后通过中序可以得知左子树为{4, 7, 2}，右子树为{5, 3, 8, 6}。接下来通过递归思想，{4, 7, 2}中4为根节点，再继续分左右子树，对{5, 3, 8, 6}也做同样操作，直至遍历结束。
 *
 * 虽然很容易能想到递归求解，但是开始写代码时可能会卡住，不知从何下手，需要传递多少参数，本题最主要就是要确定左子树与右子树在数组间的范围，再去判断下一步谁是根谁是左谁是右。
 * 或者可以使用Arrays.copyOfRange复制数组，将左子树与右子树单独复制出来进行递归。
 */
public class ReConstructBinaryTree {
    //使用递归求解
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || pre.length != in.length)
            return null;
        TreeNode node = new TreeNode(pre[0]);
        for(int i=0; i<pre.length; i++){
            if(pre[0] == in[i]){
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in,0,i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return node;
    }

    //解法二
    public TreeNode findBinaryTree(int[] pre, int preStart, int preEnd, int[] in ,int inStart, int inEnd){
        // 没有符合前序和中序的二叉树或已经到达叶子节点
        if(preStart>preEnd || inStart>inEnd)
            return null;

        // 根节点
        TreeNode root = new TreeNode(pre[preStart]);

        for(int i=inStart;i<=inEnd;i++){
            if(in[i]==pre[preStart]){
                // i-startIn 为左子树个数
                root.left = findBinaryTree(pre, preStart+1, i-inStart+preStart, in, inStart, i-1);
                // (i-startIn+startPre)+1：左子树的下一个开始为右子树
                root.right = findBinaryTree(pre, i-inStart+preStart+1, preEnd, in, i+1, inEnd);
            }
        }
        return root;
    }


}
