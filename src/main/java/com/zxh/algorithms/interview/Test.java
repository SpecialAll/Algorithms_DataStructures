package com.zxh.algorithms.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ningque
 * @Date: 2020/9/28
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] array = str.toCharArray();
        char[] temp = new char[array.length];
        int s = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] != ','){
                temp[s++] = array[i];
            }
        }
        int[] ans = new int[s];
        for(int i=0; i<s; i++){
            for(int j=0; j<s; j++){
                if(temp[j] < temp[i]) {
                    ans[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(ans));
    }
    public int[] get(int[] nums){
        int[] ans = new int[nums.length];
        int[] temp = nums;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(nums[j] < nums[i]) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
