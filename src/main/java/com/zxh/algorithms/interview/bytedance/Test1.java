package com.zxh.algorithms.interview.bytedance;

import java.util.Scanner;

/**
 * @Author: ningque
 * @Date: 2020/10/11
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        System.out.println(finMax(nums, n));
    }

    private static int finMax(int[] nums, int n) {
        int max = 0;
        for(int i=0 ;i<n; i++){
            boolean flag = true;
            int temp = nums[i];
            if(i+temp <= n){
                for(int j=1; j<temp; j++){
                    if(nums[i+j] < nums[i]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    max = Math.max(max, temp*temp);
                }
            }
        }
        return max;
    }
}
