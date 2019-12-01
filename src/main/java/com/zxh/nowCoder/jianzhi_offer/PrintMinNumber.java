package com.zxh.nowCoder.jianzhi_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/1
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String printMin(int[] numbers){
        int num = numbers.length;
        String ans = "";
        if(num == 0)
            return ans;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<num; i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 +""+str2;
                String s2 = str2 +""+ str1;
                return s1.compareTo(s2);
            }
        });
        for(int n : list){
            ans += n;
        }
        return ans;
    }
}
