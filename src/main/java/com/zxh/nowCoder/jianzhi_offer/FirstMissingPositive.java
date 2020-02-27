package com.zxh.nowCoder.jianzhi_offer;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/2/25
 */
public class FirstMissingPositive {
    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     *
     * 示例 1:
     *
     * 输入: [1,2,0]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [3,4,-1,1]
     * 输出: 2
     * 示例 3:
     *
     * 输入: [7,8,9,11,12]
     * 输出: 1
     * 说明:
     *
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
     *
     * @param nums
     * @return
     */

    /**
     * 遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置(如4放在下标为3的位置），
     * 然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加1。
     *
     * */
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int len = nums.length;
        for(i=0; i<len; i++){
            while(nums[i] >0 && nums[i] <= len && nums[nums[i]-1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(i=0; i<len; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return i+1;
    }

    /**
     * 作者：小错。
     * 链接：https://www.nowcoder.com/discuss/370435?type=2
     * 来源：牛客网
     *
     * 由于记账错误，给定的一个正整数序列里面，有两个数字重复了，同时缺少了一个数字。 要求写一个函数，找出序列中重复的数字和缺少的数字。
     * （set、异或） 例如： 输入：[1, 5, 2, 2, 3] 输出：[2, 4] 附加： 如果题目为缺少x个数字，并且输入序列可能有不匹配的重复和缺少项
     * @param nums
     */
    public static void func(int[] nums){
        int i =0;
        int len = nums.length;
        int ans1=0 , ans2 = 0;
        for(i=0; i<len; i++){
            while(nums[i] >0 && nums[i] <= len && nums[nums[i] - 1] != nums[i] ){
                int temp = nums[nums[i] - 1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for(i=0; i<len; i++){
            if(nums[i] != i+1){
                ans2 = i+1;
                ans1 = nums[i];

            }
//            System.out.println(nums[i]);
        }
        System.out.println(ans1+" : "+ans2);
    }

    public static void main(String[] args) {
        func(new int[]{1,1,2,4,3,6});
    }
}
