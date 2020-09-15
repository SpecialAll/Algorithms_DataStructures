package com.zxh.nowCoder.jianzhi_offer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/19
 */

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Duplicate {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length == 0 || length == 1)
            return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean flag = false;
        for(int i=0; i<length; i++){
            if(map.containsKey(numbers[i])){
                duplication[0] = numbers[i];
                flag = true;
                break;
            } else {
                map.put(numbers[i], 1);
            }
        }
        return flag;
    }

    public static boolean duplicate2(int numbers[],int length,int [] duplication) {
        if(length == 0 || numbers == null || length == 1){
            return false;
        }
        Arrays.sort(numbers);
        int i=0;
        for(; i<length-1; i++){
            if(numbers[i] == numbers[i+1]){
                duplication[0] = numbers[i];
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 4, 2, 1, 4};
        int[] ans = new int[]{0};
        int[] numbers2 = new int[]{2,4,3,1,4};
        System.out.println(duplicate2(numbers2, 5, ans));
        System.out.println(ans[0]);
    }
}
