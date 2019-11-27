package com.zxh.nowCoder.jianzhi_offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/27
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {
    /**
     * 采用hashmap存储键值对的方式解决；
     */
    public static int MoreThanHalfNum_Solution1(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++){
            if(map.containsKey(array[i])){
                int n = map.get(array[i]);
                map.put(array[i], n+1);
            } else {
                map.put(array[i], 1);
            }
        }
        int max = 0;
        int temp = 0;
        for(int key : map.keySet()){
            temp = map.get(key);
            if(temp > array.length/2){
                max = key;
                break;
            }
        }
        return max;
    }

    /**
     * 数组排序后，如果符合条件的数存在，则一定是数组中间那个数。（比如：1，2，2，2，3；或2，2，2，3，4；或2，3，4，4，4等等）
     * 这种方法虽然容易理解，但由于涉及到快排sort，其时间复杂度为O(NlogN)并非最优；
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution(int[] array) {
        int len = array.length;
        if(len == 0)
            return 0;
        Arrays.sort(array);
        int num = array[len/2];
        int count = 0;
        for(int i=0; i<len; i++){
            if(array[i] == num){
                count++;
            }
        }
        return count>len/2 ? num : 0;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println("数字为： "+MoreThanHalfNum_Solution(array));
    }
}
