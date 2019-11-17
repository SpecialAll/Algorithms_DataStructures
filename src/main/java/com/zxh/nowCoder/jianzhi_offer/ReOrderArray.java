package com.zxh.nowCoder.jianzhi_offer;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/17
 *
 * 题目描述：
 *  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *  使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * /**
 *  * 1.要想保证原有次序，则只能顺次移动或相邻交换。
 *  * 2.i从左向右遍历，找到第一个偶数。
 *  * 3.j从i+1开始向后找，直到找到第一个奇数。
 *  * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
 *  * 5.終止條件：j向後遍歷查找失敗。
 *  */

public class ReOrderArray {
    public static int[] reOrderArray(int array[]){
        int left = 0, right = 0;
        while(left<array.length-1 ){
            right = left + 1;
            if(isEven(array[left])){
                while(isEven(array[right]) && right<array.length-1)
                    right++;
                if(!isEven(array[right]) && right < array.length){
                    int temp = array[right];
                    for(int i=right; i>left; i--){
                        array[i] = array[i-1];
                    }
                    array[left] = temp;
                }
            }
            left++;
        }
        return array;
    }
    public static boolean isEven(int num){
        return num%2 == 0 ? true : false;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        System.out.println(Arrays.asList(reOrderArray(array)).toString());
    }
}
