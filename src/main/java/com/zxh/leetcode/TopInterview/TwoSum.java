package com.zxh.leetcode.TopInterview;

import java.util.HashMap;

/**
 * 题目描述
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 解析思路：
 *  方法三：一遍哈希表
 * 事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
 * 如果它存在，那我们已经找到了对应解，并立即将其返回。
 *
 *
 * 思路：
 *  也可以采用头尾指针法，但是需要将数组进行排序操作！
 *
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                ans[0] = map.get(temp);
                ans[1] = i;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
