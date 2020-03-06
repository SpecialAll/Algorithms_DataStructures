package com.zxh.algorithms.tree;

import com.zxh.leetcode.tencent.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 *
 * 后序遍历
 */
public class PostOrder {
    ArrayList<TreeNode> list = new ArrayList<>();

    /**
     * 递归方式遍历
     */
    public void postOrder(TreeNode root){
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        list.add(root);
    }

    /**
     * 非递归实现
     * 后序遍历的非递归算法是三种顺序中最复杂的，
     * 原因在于，后序遍历是先访问左、右子树,再访问根节点，而在非递归算法中，利用栈回退到时，
     * 并不知道是从左子树回退到根节点，还是从右子树回退到根节点，如果从左子树回退到根节点，此时就应该去访问右子树，
     * 而如果从右子树回退到根节点，此时就应该访问根节点。
     * 所以相比前序和后序，必须得在压栈时添加信息，以便在退栈时可以知道是从左子树返回，还是从右子树返回进而决定下一步的操作。
     */
    public void postOrder2(TreeNode root){
        if(root == null)
            return;
        int left = 1;
        int right = 2;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();  //辅助栈，用于记录返回时的节点位置
        while (root != null || !stack.isEmpty()){
            while (root != null){
                //将辅助栈中的值为左子树返回
                stack.push(root);
                tempStack.push(left);
                root = root.left;
            }
            //代表从左子树返回，此时将标记改为右子树，从右子树查找
            if(!stack.isEmpty() && tempStack.peek()==left){
                stack.pop();
                tempStack.push(right);
                root = stack.peek().right;
            }
            //代表从右子树返回，返回至根节点
            if(!stack.isEmpty() && tempStack.peek() == right){
                //该节点就是获取的节点
                tempStack.pop();
                list.add(stack.pop());
            }
        }
    }






























    public void post(TreeNode node){
        if(node == null)
            return;
        int left = 1;
        int right = 2;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                tempStack.push(left);
                node = node.left;
            }
            if(!stack.isEmpty() || tempStack.peek() == left){
                stack.pop();
                tempStack.push(right);
                node = stack.peek().right;
            }
            if(!stack.isEmpty() || tempStack.peek() == right){
                tempStack.pop();
                list.add(stack.pop());
            }
        }
    }
}
