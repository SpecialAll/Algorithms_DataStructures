package com.zxh.algorithms.experiment.second_sort;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */
import java.lang.Math;

public class TestSort {
    public double testInsertionTime(int[] a,int times) {
        int N = a.length,count = 0;
        long total = 0;
        while(count < times) {
            for(int i = 0;i < a.length;i++)
                a[i] = (int)(Math.random()*100000);
            long timeStart = System.currentTimeMillis();
            InsertionSort.sort(a);
            long timeEnd = System.currentTimeMillis();
            long timeInterval = timeEnd - timeStart;
            total += timeInterval;
            count++;
        }
        return (double)(total)/times;

    }

    public double testMergeSortTime(int[] a,int times) {
        int N = a.length,count = 0;
        long total = 0;
        while(count < times) {
            for(int i = 0;i < a.length;i++)
                a[i] = (int)(Math.random()*100000);
            long timeStart = System.currentTimeMillis();
            MergeSort.sort(a);
            long timeEnd = System.currentTimeMillis();
            long timeInterval = timeEnd - timeStart;
            total += timeInterval;
            count++;
        }
        return (double)(total)/times;

    }

    public double testQuickSortTime(int[] a,int times) {
        int N = a.length,count = 0;
        long total = 0;
        while(count < times) {
            for(int i = 0;i < a.length;i++)
                a[i] = (int)(Math.random()*100000);
            long timeStart = System.currentTimeMillis();
            QuickSort.sort(a);
            long timeEnd = System.currentTimeMillis();
            long timeInterval = timeEnd - timeStart;
            total += timeInterval;
            count++;
        }
        return (double)(total)/times;
    }

    public double testThreeWayQuickSortTime(int[] a,int times) {
        int N = a.length,count = 0;
        long total = 0;
        while(count < times) {
            for(int i = 0;i < a.length;i++)
                a[i] = (int)(Math.random()*100000);
            long timeStart = System.currentTimeMillis();
            ThreeWayQuickSort.sort(a);
            long timeEnd = System.currentTimeMillis();
            long timeInterval = timeEnd - timeStart;
            total += timeInterval;
            count++;
        }
        return (double)(total)/times;
    }


    public double testBUMergeSortTime(int[] a,int times) {
        int N = a.length,count = 0;
        long total = 0;
        while(count < times) {
            for(int i = 0;i < a.length;i++)
                a[i] = (int)(Math.random()*100000);
            long timeStart = System.currentTimeMillis();
            BottomupMergesort.sort(a);
            long timeEnd = System.currentTimeMillis();
            long timeInterval = timeEnd - timeStart;
            total += timeInterval;
            count++;
        }
        return (double)(total)/times;
    }

    public double testQSonRepetitiveEntries(int[] a,int times) {
        int N = a.length,count = 0;
        long total = 0;
        while(count < times) {
            for(int i = 0;i < a.length;i++)
                a[i] = (int)(Math.random()*10);
            long timeStart = System.currentTimeMillis();
            QuickSort.sort(a);
            long timeEnd = System.currentTimeMillis();
            long timeInterval = timeEnd - timeStart;
            total += timeInterval;
            count++;
        }
        return (double)(total)/times;
    }
    public double testThreeWayRepetitveQuickSortTime(int[] a,int times) {
        int N = a.length,count = 0;
        long total = 0;
        while(count < times) {
            for(int i = 0;i < a.length;i++)
                a[i] = (int)(Math.random()*10);
            long timeStart = System.currentTimeMillis();
            ThreeWayQuickSort.sort(a);
            long timeEnd = System.currentTimeMillis();
            long timeInterval = timeEnd - timeStart;
            total += timeInterval;
            count++;
        }
        return (double)(total)/times;
    }


    public static void main(String args[]) {
        int[] a = new int[10];
        int[] b = new int[1000];
        int[] c = new int[100000];
        TestSort TestSort1 = new TestSort();

        System.out.println("the average running time of Insertion sort on 10 inputs is "+TestSort1.testInsertionTime(a,10)+"ms");
        System.out.println("the average running time of Top-down Mergesort sort on 10 inputs is "+TestSort1.testMergeSortTime(a,10)+"ms");
        System.out.println("the average running time of Bottom-up Mergesort sort on 10 inputs is "+TestSort1.testBUMergeSortTime(a,10)+"ms");
        System.out.println("the average running time of Quicksort sort on 10 inputs is "+TestSort1.testQuickSortTime(a,10)+"ms");
        System.out.println("the average running time of ThreewayQuicksort sort on 10 inputs is "+TestSort1.testThreeWayQuickSortTime(a,10)+"ms");
        System.out.print("\n");
        System.out.println("the average running time of Insertion sort on 1000 inputs is "+TestSort1.testInsertionTime(b,10)+"ms");
        System.out.println("the average running time of Top-down Mergesort sort on 1000 inputs is "+TestSort1.testMergeSortTime(b,10)+"ms");
        System.out.println("the average running time of Bottom-up Mergesort sort on 1000 inputs is "+TestSort1.testBUMergeSortTime(b,10)+"ms");
        System.out.println("the average running time of Quicksort sort on 1000 inputs is "+TestSort1.testQuickSortTime(b,10)+"ms");
        System.out.println("the average running time of ThreewayQuicksort sort on 1000 inputs is "+TestSort1.testThreeWayQuickSortTime(b,10)+"ms");
        System.out.print("\n");
        System.out.println("the average running time of Insertion sort on 100000 inputs is "+TestSort1.testInsertionTime(c,10)+"ms");
        System.out.println("the average running time of Top-down Mergesort sort on 100000 inputs is "+TestSort1.testMergeSortTime(c,10)+"ms");
        System.out.println("the average running time of Bottom-up Mergesort sort on 100000 inputs is "+TestSort1.testBUMergeSortTime(c,10)+"ms");
        System.out.println("the average running time of Quicksort sort on 100000 inputs is "+TestSort1.testQuickSortTime(c,10)+"ms");
        System.out.println("the average running time of ThreewayQuicksort sort on 100000 inputs is "+TestSort1.testThreeWayQuickSortTime(c,10)+"ms");
        System.out.print("\n");
        System.out.println("the average running time of Quicksort sort on 100000 repetitive inputs is "+TestSort1.testQSonRepetitiveEntries(c,10)+"ms");
        System.out.println("the average running time of ThreewayQuicksort sort on 100000 repetitive inputs is "+TestSort1.testThreeWayRepetitveQuickSortTime(c,10)+"ms");

    }

}

