package com.zxh.algorithms.interview.tencent;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/24
 */

/**
 * 输出二维蛇形矩阵，格式如下：
 * 1 2 3 4 5
 * 16 17 18 19 6
 * 15 24 25 20 7
 * 14 23 22 21 8
 * 13 12 11 10 9
 *
 * 1、可以使用数组存储之后打印
 * 2、不可以使用数组，逐行打印
 */
public class PrintMatrix {
    public static void main(String[] args) {
        print1(5);
    }

    /**
     * 使用数组存储的方法
     * @param n 矩阵的边长度 n阶矩阵
     */
    private static void print1(int n){
        int[][] ans = new int[n][n];
        int count = 1;
        if(n == 1)
            System.out.println(1);
        else {
            int i;
            for(i=0; i<n; i++){
                for(int j=i; j<n-i; j++){
                    ans[i][j] = count;
                    count++;
                }

                for(int k=i+1; k<n-i-1; k++){
                    ans[k][n-i-1] = count;
                    count++;
                }

                for(int m=n-i-1; m>i; m--){
                    ans[n-i-1][m] = count;
                    count++;
                }

                for(int l=n-i-1; l>i; l--){
                    ans[l][i] = count;
                    count++;
                }

                //如果边是奇数，则将空填上
                if(n%2 == 1){
                    ans[n/2][n/2] = n*n;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

}
