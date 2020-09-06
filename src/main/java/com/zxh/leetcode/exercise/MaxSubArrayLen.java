package com.zxh.leetcode.exercise;

import java.util.HashMap;

/**
 * @Author: ningque
 * @Date: 2020/9/5
 * @Version 1.0
 */
public class MaxSubArrayLen {
    /**
     * Leetcode #325: 和等于 k 的最长子数组长度
     * https://blog.csdn.net/weixin_39784818/article/details/93567095?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param
     * @param array
     * @param k
     * @return
     */
    public  int maxSubArrayLen(int[] array, int k){
        if (array == null || array.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // 很重要的步骤
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i=0; i<array.length; i++){
            sum += array[i];
            if(map.containsKey(sum - k)){
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return len;
    }
}
