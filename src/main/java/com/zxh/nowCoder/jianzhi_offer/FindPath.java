package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.TreeNode;

import java.util.ArrayList;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/23
 *
 * 题目描述
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 *
 */
public class FindPath {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if(root == null)
            return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            //不重新new的话从始至终listAll中所有引用都指向了同一个一个list......
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        //这一步是回退到父节点继续寻找
        list.remove(list.size() - 1);
        return listAll;
    }
}
