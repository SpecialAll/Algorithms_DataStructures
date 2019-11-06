package com.zxh.nowCoder.byteDance_2019_spring;

import java.util.*;

/**
 * 请听题：给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
 * 注意：
 * 1. 两个特工不能埋伏在同一地点
 * 2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用
 *
 * 输入描述:
 * 第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)
 *
 * 第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，从小到大排列（将字节跳动大街看做一条数轴）
 *
 * 输出描述:
 * 一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模
 * 示例1
 * 输入
 * 4 3
 * 1 2 3 4
 * 输出
 * 4
 * 说明
 * 可选方案 (1, 2, 3), (1, 2, 4), (1, 3, 4), (2, 3, 4)
 *
 * 解决思路：
 *  思路:
 * 给三个特工选择位置,其实就是一个组合的问题.
 * 给定了元素个数n,且是增序排列.将其放入一个数组a中,通过两个指针构建一个滑动窗口.需要满足a[j]-a[i]<=D,
 * 这个范围内的元素个数就是m=(j-i+1),但是此时第一个位置已经被选中,所以需要在剩下的位置中任选2,也就是求C(m-1,2).
 * 注意: 在循环中滑动窗口是左闭右开,因此可以放置剩下两个特工的长度为:len=(j-i-1)
 *
 */
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        if(N < 2)
            return;
        int[] temp = new int[N];
        for(int i=0; i<N; i++){
            temp[i] = sc.nextInt();
        }
        int left = 0, right = 2;
        long ans = 0;
        while(right < N){
            if((temp[right] - temp[left]) > D)
                left++;
            else if((right - left) < 2)
                right++;
            else {
                ans += count(right - left);
                right++;
            }
        }
        ans %= 99997867;
        System.out.println(ans);
    }

    public static long count(long n){
        return n*(n-1)/2;
    }
}