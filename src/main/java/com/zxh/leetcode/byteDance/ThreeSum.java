package com.zxh.leetcode.byteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        //先对nums进行排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        //注意这里的临界条件nums.length-2 因为是三数之和，所以要保证最后还有三个数
        for(int i=0; i<nums.length-2; i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){ //避免掉一些重复数字的时间浪费
                //使用前后指针，注意这里的l和r可以更好的理解前面的临界条件
                int l=i+1, r=nums.length-1, sum = 0 - nums[i]; //将三个数转换为两个数求和
                while(l<r){
                    if(nums[l] + nums[r] == sum){
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while(l<r && nums[l] == nums[l+1]) l++;
                        while(l<r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }else if(nums[l] + nums[r] < sum){
                        while(l<r && nums[l] == nums[l+1]) l++;
                        l++;
                    }else {
                        while(l<r && nums[r] == nums[r-1]) r--;
                        r--;
                    }
                }
            }
        }
        return ans;
    }

}
