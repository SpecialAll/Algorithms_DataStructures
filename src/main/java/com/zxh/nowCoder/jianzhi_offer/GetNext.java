package com.zxh.nowCoder.jianzhi_offer;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/17
 */

/**
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {
    /**
     * 需要去分析中序遍历的规律
     * @param node
     * @return
     */
    public TreeLinkNode getNext(TreeLinkNode node){
        if(node == null)
            return null;
        /**
         * 如果是根节点，那下一个节点就是先找到右子树，再从该右子树不断遍历左节点，直到叶子节点就是所求节点
         */
        if(node.right != null){
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
        //如果是没有左子树右子树，那下一个节点就是该节点的父节点
        while(node.next != null){
            if(node.next.left == node)
                return node.next;
            node = node.next;
        }
        return null;
    }
}
