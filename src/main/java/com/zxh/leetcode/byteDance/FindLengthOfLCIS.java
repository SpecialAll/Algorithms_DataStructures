package com.zxh.leetcode.byteDance;

/**
 * 题目描述：
 *  给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 *
 *
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        int length = nums.length-1;
        int i = 1,max = 0,temp = 1;
        while(i <= length){
            if(nums[i-1] < nums[i]){
                i++;
                temp++;
            }
            else{
                if(max<temp){
                    max = temp;
                }
                temp = 1; //每次应该是从1开始的！！！
                i++;
            }
        }
        if(max<temp){ //需要判断一下，因为部分数组是有序的不会进入到else语句！！！
            max = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,2,3,4,5};
        FindLengthOfLCIS lengthOfLCIS = new FindLengthOfLCIS();
        System.out.println("最大长度为： "+lengthOfLCIS.findLengthOfLCIS(nums));
    }
}
