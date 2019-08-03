package com.zxh.leetcode.tencent;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


//  Definition for a binary tree node.   TreeNode

/*
  题目描述：
      给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

        说明：
        你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

        示例 1:

        输入: root = [3,1,4,null,2], k = 1
           3
          / \
         1   4
          \
           2
        输出: 1
        示例 2:

        输入: root = [5,3,6,2,4,null,null,1], k = 3
               5
              / \
             3   6
            / \
           2   4
          /
         1
        输出: 3
        进阶：
        如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？

        解题思路：
           需要熟悉二叉搜索树、中序遍历的特点

*/

    class Solution230 {
        private int i=1;
        private int res ;
        public int kthSmallest(TreeNode root, int k) {
            //使用中序遍历方式获取第K小元素
            midOrder(root,k);
            return res;
        }
        private void midOrder(TreeNode root,int k){
            if(root==null)
                return ;
            midOrder(root.left,k);
            //设置结束返回标志，表示已经找到第K小的值了，不用继续递归
            if(i>k)
                return;
            if(i++ == k){
                res=root.val;
                return;
            }
            midOrder(root.right,k);
        }
    }

    public class KthSmallest {
        public static TreeNode stringToTreeNode(String input) {
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) {
                return null;
            }

            String[] parts = input.split(",");
            String item = parts[0];
            TreeNode root = new TreeNode(Integer.parseInt(item));
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.add(root);

            int index = 1;
            while(!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.remove();

                if (index == parts.length) {
                    break;
                }

                item = parts[index++];
                item = item.trim();
                if (!item.equals("null")) {
                    int leftNumber = Integer.parseInt(item);
                    node.left = new TreeNode(leftNumber);
                    nodeQueue.add(node.left);
                }

                if (index == parts.length) {
                    break;
                }

                item = parts[index++];
                item = item.trim();
                if (!item.equals("null")) {
                    int rightNumber = Integer.parseInt(item);
                    node.right = new TreeNode(rightNumber);
                    nodeQueue.add(node.right);
                }
            }
            return root;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                TreeNode root = stringToTreeNode(line);
                line = in.readLine();
                int k = Integer.parseInt(line);

                int ret = new Solution230().kthSmallest(root, k);

                String out = String.valueOf(ret);

                System.out.print(out);
            }
        }
    }


