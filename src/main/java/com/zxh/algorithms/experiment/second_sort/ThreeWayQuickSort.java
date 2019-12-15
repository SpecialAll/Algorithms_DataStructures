package com.zxh.algorithms.experiment.second_sort;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */

public class ThreeWayQuickSort {
    public static void sort(int[] a) {
        sort(a,0,a.length-1);
    }
    private static void sort(int[] a,int lo,int hi) {
        if(hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        int v = a[lo];
        while(i <= gt) {
            int cmp;
            if(a[i] < v)
                cmp = -1;
            else if(a[i] > v)
                cmp = 1;
            else
                cmp = 0;

            if (cmp < 0) {
                int t = a[lt];
                a[lt] = a[i];
                a[i] = t;
                lt++;i++;

            }
            else if(cmp > 0) {
                int t = a[i];
                a[i] = a[gt];
                a[gt] = t;
                gt--;
            }
            else i++;
        }

        sort(a,lo,lt - 1);
        sort(a,gt + 1 ,hi);


    }
}

