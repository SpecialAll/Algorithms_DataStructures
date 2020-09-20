package com.zxh.nowCoder.jianzhi_offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: ningque
 * @Date: 2020/9/17
 * @Version 1.0
 */
public class GetMedian {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2){
            return o2 - o1;
        }
    });
    int count = 0;
    public void Insert(Integer num) {
        if(count % 2 == 0){
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        } else {
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double GetMedian() {
        if(count % 2 == 0){
            return (double) (minHeap.peek() + maxHeap.peek()) /2;
        } else {
            return (double) minHeap.peek();
        }
    }


}
