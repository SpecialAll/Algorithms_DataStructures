package com.zxh.leetcode.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
  使用回溯法求解：
      回溯法 是一种通过探索所有可能的候选解来找出所有的解的算法。如果候选解被确认 不是 一个解的话（或者至少不是 最后一个 解），回溯算法会通过在上一步进行一些变化抛弃该解，即 回溯 并且再次尝试。

      这里有一个回溯函数，使用第一个整数的索引作为参数 backtrack(first)。

        1、如果第一个整数有索引 n，意味着当前排列已完成。
        2、遍历索引 first 到索引 n - 1 的所有整数。Iterate over the integers from index first to index n - 1.
              在排列中放置第 i 个整数， 即 swap(nums[first], nums[i]).
              继续生成从第 i 个整数开始的所有排列: backtrack(first + 1).
              现在回溯，即通过 swap(nums[first], nums[i]) 还原.

* */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList();
        ArrayList<Integer> num_list = new ArrayList<Integer>();


        for(int num : nums){
            num_list.add(num);
        }

        int n = nums.length;
        backtrack(n-1, num_list, output, 0);
        return output;

    }
    public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first){
        if(first == n)
            output.add(new ArrayList<Integer>(nums));
        for(int i=first; i<n; i++){
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first+1);
            Collections.swap(nums, first ,i);
        }
    }
}

public class FullPermutation {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new Solution().permute(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
