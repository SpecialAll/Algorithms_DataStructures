package com.zxh.leetcode.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author: ningque
 * @Date: 2020/9/13
 * @Version 1.0
 */
public class Test2 {
    /**
     * 寻找礼物的种类数量
     * @param args
     */
    public static void main(String[] args) {
        findGift();
    }
    public static void findGift(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] data = new int[n];
        for(int i=0; i<n; i++){
            data[i] = sc.nextInt();
        }

        if(n < m) {
            System.out.println(0);
        }

        int start = 0;
        int end = m;
        int count = 0;
        while (end <= n){
            int j=start;
            for(; j<end; j++){
                if(data[j] < k){
                    break;
                }
            }
            if(j>=end){
                count++;
            }
            start += 1;
            end += 1;
        }
        System.out.println(count);
    }
}
