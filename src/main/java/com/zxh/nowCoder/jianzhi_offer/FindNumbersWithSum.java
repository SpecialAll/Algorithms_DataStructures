package com.zxh.nowCoder.jianzhi_offer;

import java.util.ArrayList;

import static java.lang.Integer.MAX_VALUE;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/8
 *
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(array.length <= 0)
            return ans;
        int index = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] == sum) {
                index = i;
                break;
            }
        }
        if(index == 0)
            index = array.length-1;
        int max = MAX_VALUE;
        for(int i = index; i>=0; i--){
            for(int j=0; j<i; j++){
                if(array[i] + array[j] == sum){
                    int temp = array[i] * array[j];
                    if(temp < max){
                        if(!ans.isEmpty()){
                            ans.remove(0);
                            ans.remove(1);
                        }
                        ans.add(array[j]);
                        ans.add(array[i]);
                        max = temp;
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        FindNumbersWithSum sum = new FindNumbersWithSum();
        int[] arr = {1,2,4,7,11,16};
        System.out.println(sum.FindNumbersWithSum(arr,11));
    }
}
