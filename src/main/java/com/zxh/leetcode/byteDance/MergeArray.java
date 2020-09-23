package com.zxh.leetcode.byteDance;

/**
 * @Author: ningque
 * @Date: 2020/9/23
 * @Version 1.0
 */
public class MergeArray {
    /**
     * 题目描述：
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 初始化 A 和 B 的元素数量分别为 m 和 n。
     *
     *
     * 思路：
     *  如果是在原来数组上存储则考虑从数组尾部开始遍历比较
     *
     */
    public void mergeArray(int[] A, int n, int[] B, int m){
        int i = n - 1, j = m - 1;
        int index = n + m - 1;
        while (i >= 0 && j >= 0){
            if(A[i] > B[j]) {
                A[index] = A[i];
                i--;
                index--;
            } else {
                A[index] = B[j];
                j--;
                index--;
            }
        }
        while (i >= 0){
            A[index] = A[i];
            i--;
            index--;
        }
        while (j >= 0){
            A[index] = B[j];
            j--;
            index--;
        }
    }
}
