package com.zxh.leetcode.exercise;

import java.util.Scanner;

/**
 * @Author: ningque
 * @Date: 2020/9/13
 * @Version 1.0
 */
public class Test {
    /**
     * 寻找最小子矩阵（美团笔试）
     * @param args
     */
    public static void main(String[] args) {
        findMin();
    }
    public static void findMin(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] data = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                data[i][j] = sc.nextInt();
            }
        }
        if(n == 1){
            for(int i=0; i<m; i++){
                System.out.printf(data[0][i]+" ");
            }
            return;
        }

        find(data, n/2, n, m);
    }
    public static void find(int[][] data, int mid, int end,  int m){
        int i=0, j=end-1;
        for(; i<mid && j>=mid; i++, j--){
            int k=0;
            for(; k<m; k++){
                if(data[i][k] != data[j][k]) {
                    break;
                }
            }
            if(k<m){
                for(int l=0; l<end; l++){
                    for(int s=0; s<m; s++){
                        System.out.printf(data[l][s]+" ");
                    }
                    System.out.println();
                }
                break;
            }
        }
        if(i>mid || j<mid){
            find(data, mid/2, mid, m);
        }
    }
}
