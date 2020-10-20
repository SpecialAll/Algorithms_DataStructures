package com.zxh.algorithms.interview.bytedance;

import java.util.*;

/**
 * @Author: ningque
 * @Date: 2020/10/19
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        input = input.trim();
        String[] parts = input.split(" ");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        Arrays.sort(output);
        int i = 0;
        for(i=0; i<output.length; i++){
            if(output[i] != 0){
                break;
            }
        }
        int min = 0;

        if(i == output.length){
            System.out.println(-1);
            return;
        } else if(i >= 2 && i <= 5){
            min = output[i] * 100;
        } else {
            if(output[0] != 0 && output[1] <= output[2]){
                min = output[0]*100 + output[1]*10 + output[2];
            } else if(output[0] != 0 && output[1] > output[2]){
                min = output[0]*100 + output[1] + output[2]*10;
            } else if(output[0] == 0 && output[1] >= output[2]){
                min = output[0]*10 + output[1] + output[2]*100;
            } else if(output[0] == 0 && output[1] < output[2]){
                min = output[0]*10 + output[1]*100 + output[2];
            }
        }

        int max = output[5]*100 + output[4]*10 + output[3];
        System.out.println(max-min);

    }
}
