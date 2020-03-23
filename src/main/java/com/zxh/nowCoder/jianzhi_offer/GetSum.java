package com.zxh.nowCoder.jianzhi_offer;

import java.util.Scanner;

import static java.lang.Math.sqrt;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/19
 */
public class GetSum {
    public static String getSum(int num, int start){
        int max = Integer.MAX_VALUE;

        StringBuffer ans = new StringBuffer();
        for(int i=start; i<num/2; i++){
            StringBuffer temp = new StringBuffer();
            int sum = 0;
            int len = 0;
            for(int j=i; j<num/2; j++){
                sum += j;
                temp.append(j+" ");
                len++;
                if(sum > num){
                    break;
                }
                if (sum == num){
                    if(len < max){
                        ans = temp;
                    }
                    len = 0;
                    sum = 0;
                    break;
                }
            }

        }
        if(ans.length() > 200 || ans.length() == 0)
            return "No";
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int start = sc.nextInt();
        String ans =  getSum(num, start);
        System.out.println(ans);
    }
}
