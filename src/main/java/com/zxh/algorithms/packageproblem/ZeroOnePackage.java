package com.zxh.algorithms.packageproblem;


import java.util.Scanner;

/**
 * @author  ningque
 * @Data 2020/4/26
 * @version 1.0
 *
 * 01 背包问题：DP求解
 *
 */

public class ZeroOnePackage {
    /**
     *  N 表示物体个数
     *  V 表示背包容量
     */
    private int N, V;
    /**
     * weight 存储每个物体的重量，下标从1开始
     */
    private int[] weight;
    /**
     * value 存储每个物体的收益，下标从1开始
     */
    private int[] value;
    /**
     * 二维数组存储每个状态下的最大收益
     */
    private int[][] ans;

    public static void main(String[] args) {
        /**
         * 示例1：
         * 5 10
         * 2 2 6 5 4
         * 6 3 5 4 6
         *
         * result：
         * 15
         * 1 2 5
         *
         * 示例2：
         * 50 1000
         * 80 82 85 70 72 70 66 50 55 25 50 55 40 48 50 32 22 60 30 32 40 38 35 32 25 28 30 22 50 30 45 30 60 50 20 65 20 25 30 10 20 25 15 10 10 10 4 4 2 1
         * 220 208 198 192 180 180 165 162 160 158 155 130 125 122 120 118 115 110 105 101 100 100 98 96 95 90 88 82 80 77 75 73 72 70 69 66 65 63 60 58 56 50 30 20 15 10 8 5 3 1
         *
         * result:
         * 3103
         * 1 2 4 6 8 9 10 11 13 14 16 17 19 20 22 23 24 25 26 27 28 30 35 37 40 41 47
         */
        ZeroOnePackage zeroOnePackage = new ZeroOnePackage();
        zeroOnePackage.init();
        zeroOnePackage.zeroOnePackageDP();
        zeroOnePackage.printResult(zeroOnePackage.N, zeroOnePackage.V);
    }

    /**
     * 使用DP求解求解最大收益值
     */
    public void zeroOnePackageDP(){
        //初始化收益数组
        for(int j=0; j<=V; j++){
            ans[0][j] = 0;
        }

        //注意边界问题
        for(int i=1; i<=N; i++){
            for(int j=0; j<=V; j++){
                //容量为j存下第i个物体
                if(j >= weight[i]){
                    ans[i][j] = Math.max(ans[i-1][j - weight[i]] + value[i], ans[i-1][j]);
                } else {
                    //容量为j存不下第i个物体
                    ans[i][j] = ans[i-1][j];
                }
            }
        }

        System.out.println(ans[N][V]);

        /*//打印所有收益结果
        for (int i=0; i<=N; i++){
            for (int j=0; j<=V; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }*/
    }

    /**
     * 求解最大收益值的具体物体是哪些
     * @param n 表示前n个物体 n<=N
     * @param v 表示背包容量 v<=V
     */
    public void printResult(int n, int v){
        boolean[] isAdd = new boolean[n+1];

        for(int i=n; i>=1; i--){
            if(ans[i][v] == ans[i-1][v]){
                isAdd[i] = false;
            } else {
                isAdd[i] = true;
                v -= weight[i];
            }
        }

        for(int i=1; i<=n; i++){
            if (isAdd[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    /**
     * 初始化
     */
    public void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        V = sc.nextInt();

        //从下标为1开始
        weight = new int[N+1];
        value = new int[N+1];
        ans = new int[N+1][V+1];

        for(int i=1; i<=N; i++){
            weight[i] = sc.nextInt();
        }
        for(int j=1; j<=N; j++){
            value[j] = sc.nextInt();
        }
    }
}
