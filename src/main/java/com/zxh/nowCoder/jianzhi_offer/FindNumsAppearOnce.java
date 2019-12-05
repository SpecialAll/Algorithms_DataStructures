package com.zxh.nowCoder.jianzhi_offer;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/5
 *
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 使用亦或运算符求解！！！
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //给数组排序，然后两个相邻的数做亦或^操作，之后
        if(array == null || array.length < 2)
            return;
        Arrays.sort(array);
        int i=0;
        int temp = 0;
        while(i<array.length-1){
            temp = array[i] ^ array[i+1];
            if( temp == 0)
                i += 2;
            else {
                num1[0] = array[i];
                break;
            }
        }
        int j=i+1;
        while(j<array.length-1){
            temp = array[j]^array[j+1];
            if(temp == 0)
                j += 2;
            else {
                num2[0] = array[j];
                break;
            }
        }
        if(j == array.length - 1)
            num2[0] = array[j];
    }

    public static void main(String[] args) {
        int arr[] = {2,4,3,6,3,2,5,5};
        FindNumsAppearOnce once = new FindNumsAppearOnce();
        int num1[] = new int[1];
        int num2[] = new int[1];
        once.FindNumsAppearOnce(arr,num1, num2);
    }
}
