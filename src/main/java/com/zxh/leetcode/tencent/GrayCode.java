package com.zxh.leetcode.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
  题目描述：
      格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

      给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。

            示例 1:

            输入: 2
            输出: [0,1,3,2]
            解释:
            00 - 0
            01 - 1
            11 - 3
            10 - 2

            对于给定的 n，其格雷编码序列并不唯一。
            例如，[0,2,3,1] 也是一个有效的格雷编码序列。

            00 - 0
            10 - 2
            11 - 3
            01 - 1
            示例 2:

            输入: 0
            输出: [0]
            解释: 我们定义格雷编码序列必须以 0 开头。
                 给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
                 因此，当 n = 0 时，其格雷编码序列为 [0]。

       解题思路：

        关键是搞清楚格雷编码的生成过程, G(i) = i ^ (i/2);
        如 n = 3:
        G(0) = 000,
        G(1) = 1 ^ 0 = 001 ^ 000 = 001
        G(2) = 2 ^ 1 = 010 ^ 001 = 011
        G(3) = 3 ^ 1 = 011 ^ 001 = 010
        G(4) = 4 ^ 2 = 100 ^ 010 = 110
        G(5) = 5 ^ 2 = 101 ^ 010 = 111
        G(6) = 6 ^ 3 = 110 ^ 011 = 101
        G(7) = 7 ^ 3 = 111 ^ 011 = 100


 */
class Solution89 {
public List<Integer> grayCode(int n) {
        //格雷码的生成；i^（i/2）
        List<Integer> ret = new ArrayList<>();
        for(int i=0; i<(1<<n); i++){
        ret.add(i ^ i>>1);
        }
        return ret;
        }
        }

public class GrayCode {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            List<Integer> ret = new Solution89().grayCode(n);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}