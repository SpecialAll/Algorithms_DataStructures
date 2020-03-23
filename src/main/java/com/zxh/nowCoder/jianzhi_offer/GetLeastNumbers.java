package com.zxh.nowCoder.jianzhi_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/20
 */
public class GetLeastNumbers {
    public static int[] getLeastNumbers(int[] arr, int k){
        //int数组转list
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int[] ans = new int[k];
        /**
         * String数组转list
         *  String[] arr={“1”,”2”};
         *  List<String> collect =  Arrays.stream(arr).collect(Collectors.toList());
         */
        Collections.sort(list);
        for(int i=0; i<k; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,4,22,6};
        System.out.println(getLeastNumbers(arr, 2)[0]+" "+getLeastNumbers(arr, 2)[1]);
    }
}
