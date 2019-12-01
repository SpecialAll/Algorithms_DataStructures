package com.zxh.nowCoder.jianzhi_offer;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/1
 */
public class InversePairs {
    public static int InversePairs(int [] array) {
        int temp = array[0];
        int ans = 0;
        for(int i=1; i<array.length; i++){
            if(temp < array[i]){
                ans++;
                temp = array[i];
            }
        }
        return ans%1000000007;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(arr));
    }
}
