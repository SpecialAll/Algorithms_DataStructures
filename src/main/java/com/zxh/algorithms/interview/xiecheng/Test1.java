package com.zxh.algorithms.interview.xiecheng;

import java.util.Scanner;

/**
 * @Author: ningque
 * @Date: 2020/10/13
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int x = sc.nextInt();

        getNumCoin(x, a, b, c, m);
        System.out.println(ans);
    }

    static int ans = 0;
    private static void getNumCoin(int x, int a, int b, int c, int m) {
        if(m == 0)
            return;
        m--;
        int num = 0;
        int step = 0;
        // 包含100
        while (c != 0 && num < x){
            num += 100;
            step++;
            c--;
        }
        if(num >= x){
            ans += step;
            int temp = (num - x);
            if(temp%50 == 0){
                b++;
            } else if(temp%10 == 0){
                a += (num-x)/10;
            }
            getNumCoin(x, a, b, c, m);
            return;
        }

        // 包含50
        while (b != 0 && num < x){
            num += 50;
            step++;
            b--;
        }
        if(num >= x){
            ans += step;
            int temp = (num - x);
            if(temp%50 == 0){
                b++;
            } else if(temp%10 == 0){
                a += (num-x)/10;
            }
            getNumCoin(x, a, b, c, m);
            return;
        }

        //包含10
        while (a != 0 && num < x){
            num += 10;
            step++;
            a--;
        }
        if(num == x){
            ans += step;
            getNumCoin(x, a, b, c, m);
            return;
        }
    }
}
