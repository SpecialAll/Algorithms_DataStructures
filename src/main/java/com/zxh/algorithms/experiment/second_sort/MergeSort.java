package com.zxh.algorithms.experiment.second_sort;


/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */

public class MergeSort {
    private static int[] aux;   //归并所需要的辅助数组

    public static void merge(int[] a,int lo,int mid,int hi) {
        int i = lo, j = mid +1;
        for(int k = lo; k<= hi ;k++)
            aux[k] = a[k];
        for(int k = lo; k<= hi; k++)
            //表示左半边元素已经使用完毕，直接将右半边元素添加到数组中即可
            if (i > mid)                 a[k] = aux[j++];
            //表示右半边元素已经使用完毕，直接将左边元素添加到数组中即可
            else if(j > hi)              a[k] = aux[i++];
            //表示右边当前元素小于左边当前元素，将右边元素添加到数组中
            else if(aux[j] < aux[i])     a[k] = aux[j++];
            //表示右边当前元素大于左边当前元素，将左边元素添加到数组中
            else                         a[k] = aux[i++];
    }

    public static void sort(int[] a) {
        aux = new int[a.length];
        sort(a,0,a.length-1);
    }
    private static void sort(int[] a, int lo,int hi) {
        if(hi <= lo) return;
        int mid = lo + (hi-lo)/2;
        //使用递归操作
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

}

