package com.zxh.nowCoder.jianzhi_offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/27
 *
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers_Solution {
    /**
     * 采用冒泡排序求解
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        int length = input.length;
        ArrayList<Integer> ans = new ArrayList<>();
        if (length < k)
            return ans;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (input[i] > input[j]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            ans.add(input[i]);
        }
        return ans;
    }

    /**
     * 采用优先队列使用大顶堆实现
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        int length = input.length;
        ArrayList<Integer> ans = new ArrayList<>();
        if (length < k || k == 0)
            return ans;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                int temp = maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for (int n : maxHeap) {
            ans.add(n);
        }
        return ans;
    }
}
