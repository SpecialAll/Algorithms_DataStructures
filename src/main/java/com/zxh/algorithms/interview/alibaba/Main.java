package com.zxh.algorithms.interview.alibaba;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/20
 */
public class Main {
    /**
     * 测试用例：
     * 1 1 1 2 2 2 2 2 1 1
     *
     * 输出结果：3
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //num记录牌的总数
        int num = 0;
        //ans记录最终出牌次数
        int ans = 0;
        int temp;
        int[] cards = new int[10];
        for(int i=0; i<10; i++){
            temp = scanner.nextInt();
            cards[i] = temp;
            num += temp;
        }
        //如果只有一张牌则直接返回
        if(num == 1){
            System.out.println(1);
            return;
        }

        //使用暴力回溯发求解
        ans = getNum(cards, 0);

        System.out.println(ans);
    }
    private static  int getNum(int[] cards, int k){
        int ans = Integer.MAX_VALUE;
        if(k >= cards.length)
            return 0;
        //若牌数为0则继续下一张
        else if (cards[k] == 0){
            return getNum(cards,k+1);
        }

        //优先出连对
        if(k <= cards.length-3 && cards[k] >= 2 && cards[k+1] >= 2 && cards[k+3] >= 2){
            cards[k] -= 2;
            cards[k+1] -= 2;
            cards[k+2] -= 2;
            ans = Math.min(1+getNum(cards, k), ans);
            cards[k] += 2;
            cards[k+1] += 2;
            cards[k+2] += 2;
        }

        //出顺子
        if(k <= cards.length - 5 && cards[k] >= 1 && cards[k+1] >=1 && cards[k+2] >= 1 && cards[k+3] >= 1 && cards[k+4] >=1){
            cards[k] -= 1;
            cards[k+1] -= 1;
            cards[k+2] -= 1;
            cards[k+3] -= 1;
            cards[k+4] -= 1;
            ans = Math.min(1+getNum(cards, k), ans);
            cards[k] += 1;
            cards[k+1] += 1;
            cards[k+2] += 1;
            cards[k+3] += 1;
            cards[k+4] += 1;
        }

        //出对子
        if(cards[k] >= 2){
            cards[k] -= 2;
            ans = Math.min(1+getNum(cards, k), ans);
            cards[k] += 2;
        }

        //出单子
        if(cards[k] >= 1){
            cards[k] -= 1;
            ans = Math.min(1+getNum(cards, k), ans);
            cards[k] += 1;
        }
        return ans;
    }
}
