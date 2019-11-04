package com.zxh.contest.No161th;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 *
 *
 * 题目解析：
 *  先求取nums中奇数个数的前缀和arrarr，即arr[i]arr[i]表示numsnums数组中前ii个数有多少个奇数。
 * 则对于每一个子数组nums[i...j]nums[i...j]，其中的奇数个数可以采用arr[j]-arr[i-1]arr[j]−arr[i−1]求得。
 * 则问题转换成有多少个数对(i,j)(i,j)，其中arr[j]-arr[i] = karr[j]−arr[i]=k，这就是我们喜闻乐见的two\ sumtwo sum问题啦，用hashhash表即可O(n)O(n)解决
 *
 */
public class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k){
        int temp[] = new int[50005];
        int len = nums.length, ans = 0, cur = 0;
        temp[0] = 1;    //temp[0]需要赋值，因为当cur-k == 0 时存在一个最优美子数组
        for(int i=0; i<len; ++i){
            cur += nums[i]%2;
            if((cur - k) >= 0){
                ans += temp[cur - k];
            }
            ++temp[cur];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        NumberOfSubarrays subarrays = new NumberOfSubarrays();
        System.out.printf("length: "+subarrays.numberOfSubarrays(nums, 3));
    }
}
