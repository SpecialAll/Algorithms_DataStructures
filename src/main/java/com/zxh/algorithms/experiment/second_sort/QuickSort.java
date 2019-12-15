package com.zxh.algorithms.experiment.second_sort;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */
public class QuickSort {
    public static void sort(int[] a) {
        sort(a,0,a.length-1);
    }
    private static void sort(int[] a,int lo,int hi) {
        if(hi <= lo) return;
        //找到切分点
        int j = partition(a,lo,hi);
        //与归并不同点：递归发生在整个数组处理之后
        sort(a,lo,j-1);
        sort(a,j+1,hi);

    }

    /**
     * 关键在于切分：
     *  首先随意取一个切分元素，然后我们从数组的左端向右端扫描，找到一个大于切分元素的元素
     *  然后再从右往左扫描，直到找到一个小于切分元素的值，
     *  然后交换它们的位置，
     *  直到两指针相遇，交换当前位置与切分元素
     * */
    private static int partition(int[] a,int lo,int hi) {
        int i = lo, j=hi+1;
        int v = a[lo];   //切分元素
        while(true) {
            while(a[++i] < v) if(i == hi)  break;
            while(v < a[--j]) if(j == lo)  break;
            if(i >= j) break;
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        int t = a[j];
        a[j] = a[lo];
        a[lo] = t;
        return j;
    }

}