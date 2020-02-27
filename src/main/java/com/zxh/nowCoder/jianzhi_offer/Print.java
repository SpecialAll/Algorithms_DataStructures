package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/2/25
 */
public class Print {

    /**
     * 题目描述
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     *
     *
     * 该问题采用栈的数据结构，在奇数层，从右向左添加，在偶数层从右向左添加
     * 【解题思路1】
     * //1.使用两个栈来分别存储奇数层节点和偶数层节点。
     * //2.注意两个栈的插入顺序是不同的。
     * //3.对于奇数层来说，也就是从左往右的顺序，先添加左子树，然后添加右子树。对于偶数层，刚好相反，先添加右子树，然后添加左子树。
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        s1.push(pRoot);
        int level = 1;
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!(level%2 == 0)){
                ArrayList<Integer> temp = new ArrayList<>();
                while(!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    if(node != null){
                        temp.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }

                }
                if(!temp.isEmpty()){
                    list.add(temp);
                    level++;
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                while(!s2.isEmpty()){
                    TreeNode node = s2.pop();
                    if(node != null){
                        temp.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if(!temp.isEmpty()){
                    list.add(temp);
                    level++;
                }
            }
        }
        return list;
    }
}
