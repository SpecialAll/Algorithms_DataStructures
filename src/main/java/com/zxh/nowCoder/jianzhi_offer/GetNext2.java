package com.zxh.nowCoder.jianzhi_offer;

import java.util.ArrayList;

/**
 * @Author: ningque
 * @Date: 2020/9/16
 * @Version 1.0
 */
public class GetNext2 {
    /**
     * 题目描述
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    ArrayList<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode getNext(TreeLinkNode pNode){
        TreeLinkNode root = pNode;
        while(root.next != null){
            root = root.next;
        }
        getMidOrder(root);
        for(int i=0; i<list.size(); i++){
            if(list.get(i) == pNode){
                return i == list.size() - 1 ? null : list.get(i+1);
            }
        }
        return null;
    }
    public void getMidOrder(TreeLinkNode root){
        if(root != null){
            getMidOrder(root.left);
            list.add(root);
            getMidOrder(root.right);
        }

    }
}
