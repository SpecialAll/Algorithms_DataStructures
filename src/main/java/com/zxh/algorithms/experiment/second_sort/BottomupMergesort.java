package com.zxh.algorithms.experiment.second_sort;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */
/**
 * 自底向上的归并排序思路：
 *      先去归并微型小数组，然后归并得到的子数组；
 *      例如：
 *      开始是两两归并，然后四四归并、之后八八归并，十六十六归并。。。。。
 */

import java.lang.Math;
public class BottomupMergesort {
    public static int[] aux;
    public static void sort(int[] a) {
        int N = a.length;
        aux = new int[N];
        for(int sz = 1;sz < N; sz += sz)  //sz是子数组大小 每次是成倍增加
            for(int lo = 0; lo < N - sz ; lo += sz + sz)  //lo表示子数组的索引  每次是两个sz之和
                merge(a,lo,lo+sz-1,Math.min(lo + sz +sz - 1, N - 1));
    }
    public static void merge(int[] a,int lo,int mid,int hi) {
        int i = lo, j = mid +1;
        for(int k = lo; k<= hi ;k++)
            aux[k] = a[k];
        for(int k = lo; k<= hi; k++)
            if (i > mid)                 a[k] = aux[j++];
            else if(j > hi)              a[k] = aux[i++];
            else if(aux[j] < aux[i])     a[k] = aux[j++];
            else                         a[k] = aux[i++];
    }

}

