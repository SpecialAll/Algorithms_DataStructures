package com.zxh.contest.No160th;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：
 *      给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：
 *
 * p[0] = start
 * p[i] 和 p[i+1] 的二进制表示形式只有一位不同
 * p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
 *
 *
 * 示例 1：
 *
 * 输入：n = 2, start = 3
 * 输出：[3,2,0,1]
 * 解释：这个排列的二进制表示是 (11,10,00,01)
 *      所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
 * 示例 2：
 *
 * 输出：n = 3, start = 2
 * 输出：[2,6,7,5,4,0,1,3]
 * 解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
 *
 *
 * 提示：
 *
 * 1 <= n <= 16
 * 0 <= start < 2^n
 *
 *
 * 解题思路：
 *  其实就是格雷码的变形，将格雷码求出，然后找到start开始的位置，将start放到第一个位置，然后把其他的格雷码再添加进来！！1
 */
public class CircularPermutation {
    /**
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
     **/
    public List<Integer> circularPermutation(int n, int start) {
        //格雷码求解，找出start的位置后返回
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<(1<<n); i++){
            list.add(i ^  i>>1);
        }
        int temp = 0;
        for(int i=0; i<(1<<n); i++){
            if(list.get(i) == start){
                temp = i;
                break;
            }
        }
        for(int i=temp; i<(1<<n); i++){
            ans.add(list.get(i));
        }
        for(int i=0; i<temp; i++){
            ans.add(list.get(i));
        }
        return ans;
    }
}
