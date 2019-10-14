package com.zxh.leetcode.byteDance;

import java.util.ArrayList;

/**
 * 题目描述：
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 *
 *
 *
 *
 * 解题思路：
 * k要先变成k-1，因为现在用的是下标值，是以0开头的，k–;
 *
 * 用k对(n-1)!取商，结果为数据 余数为下一个数字
 *
 * 比如n=4,这样排列出来的数据就有[1234,1243,1324,1342,1423,1432,2134,
 * 2143,2314,2341,2413,2431,3124...]
 *
 * 第一轮：
 * 可以看到以1开头的有3*2*1 = 6种，同理2.3.4的都是这样
 * 这样8/6 = 1..2（商为1，余数为2）， 结果数据就是索引为1的2（第0个是1）
 * 然后把2从数组中移除
 *
 * 第二轮
 * 这时候数据把2除外就有[134,143,314,341,413,431]
 * 可以看到以1开头的有2*1 = 2种，同理3.4的都是这样
 * 上一把余数是2，所以2/2 = 1..0，结果数据就是索引为1的3（第0个是1）
 *
 * 第三轮
 * 这时候数据把2除外就有[14,41]
 * 可以看到以1开头的有1 =1种，同理4的都是这样
 * 上一把余数是0，所以0/1 = 0..1，结果数据就是索引为0的1（第0个是1）

 */
public class GetPermutation {
    public String getPermutation(int n, int k) {
        if(n<=1)
            return ""+n;
        ArrayList list = new ArrayList<>();
        for(int i=1; i<=n ;i++){
            list.add(i);
        }

        int leaf = n;
        k = k-1;
        StringBuilder ans = new StringBuilder();
        while(leaf > 0){
            //循环求出n-1阶乘
            int val = 1;
            for(int i=1; i<leaf; i++){
                val = val*i;
            }

            //求出下标位置
            int index = k/val;
            ans.append(list.get(index));
            list.remove(index);
            k = k % val;
            leaf--;
        }
        return ans.toString();
    }
}
