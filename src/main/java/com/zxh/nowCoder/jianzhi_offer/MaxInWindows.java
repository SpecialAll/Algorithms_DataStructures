package com.zxh.nowCoder.jianzhi_offer;

import java.util.ArrayList;

/**
 * @Author: ningque
 * @Date: 2020/9/17
 * @Version 1.0
 */
public class MaxInWindows {
    /**
     * 题目描述
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
     * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
     * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     * 窗口大于数组长度的时候，返回空
     *
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> ans = new ArrayList<>();
        if(num.length < size || size == 0){
            return ans;
        }
        int left = 0, right = size;

        while(right <= num.length){
            int max = Integer.MIN_VALUE;
            for(int i=left; i<right; i++){
                if(max < num[i]){
                    max = num[i];
                }
            }
            ans.add(max);
            left++;
            right++;
        }
        return ans;
    }
}
