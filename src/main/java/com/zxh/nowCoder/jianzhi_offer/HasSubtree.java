package com.zxh.nowCoder.jianzhi_offer;

import com.zxh.leetcode.tencent.TreeNode;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/19
 *
 * 题目描述：
 *  输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 *
 *  使用递归求解！11
 */
public class HasSubtree {
    public boolean hasSubtree(TreeNode root1, TreeNode root2){
        boolean ans = false;
        //只有两个都不为空才进行查找，否则返回false
        if(root1 != null && root2 != null){
            //如果两个的节点的值相同就意味着找到公共根节点
            if(root1.val == root2.val){
                ans = find(root1, root2);
            }
            //如果没有找到公共节点就去root1的右子树
            if(!ans){
                ans = hasSubtree(root1.left, root2);
            }
            //如果没有找到公共节点就去root1的右子树找
            if(!ans) {
                ans = hasSubtree(root1.right, root2);
            }
        }
        return ans;
    }

    private boolean find(TreeNode root1, TreeNode root2) {
        /**
         * 这里有一个坑需要注意一下
         * if (root1 == null) {
         *      return false;
         * }
         * if (root2 == null) {
         *      return true;
         * }
         * 上述写法是不能通过的，原因在于可能存在遍历结束两者都为null，root1为null，不能直接返回false；
         * 所以修改写法为：
         * if(root1 == null && root2 != null)
         *       return false;
         * if(root2 == null)
         *       return true;
         */
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return find(root1.left, root2.left) && find(root1.right, root2.right);
    }
}
