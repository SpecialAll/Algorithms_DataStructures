package com.zxh.leetcode.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目秒速：
 *  给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 *  示例 1:
 *
 *  输入:
 *  [
 *   [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *   [ 7, 8, 9 ]
 *  ]
 *  输出: [1,2,3,6,9,8,7,4,5]
 *
 *  解题思路：
 *      使用循环打印，和循环矩阵II差不多，就是循环条件有差异！！！
 *
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return list;
        int l = 0, t = 0;
        int r = (matrix[0].length)-1, h = (matrix.length)-1;

        while(true){
            for(int i=l; i<=r; i++){
                list.add(matrix[t][i]);
            }
            if(++t > h)
                break;
            for(int i=t; i<=h; i++){
                list.add(matrix[i][r]);
            }
            if(--r < l)
                break;
            for(int i=r; i>=l; i--){
                list.add(matrix[h][i]);
            }
            if(--h < t)
                break;
            for(int i=h; i>=t; i--){
                list.add(matrix[i][l]);
            }
            if(++l > r)
                break;
        }
        return list;
    }
}
