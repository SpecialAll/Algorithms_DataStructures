package com.zxh.algorithms.interview.meituan;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/19
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 美团 2020春招 技术综合试卷在线考试
 * 编程题 | 20.0分3/5
 * 任务最大得分
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 现在一共有n个任务可以完成。对于每个任务，都有k个子任务可以做。并且第 i 个子任务需要花费的时间是 ti 。我们可以认为一个子任务需要的时间只和这个子任务是第几个子任务有关，而不和这是属于哪个任务有关。也就是说n个任务的第 i 个子任务需要的时间都是一样的。
 *
 * 每个任务都只可以完成一次，同时每个子任务也只能完成一次，任何任务都不能重复完成。
 *
 * 每当你完成一个子任务你会获得p分，而当你完成一个任务的k个子任务后，你会获得额外的q分，也就是说你会获得pk+q分。
 *
 * 现在你一共有m的时间，你需要求出最大的得分。
 *
 * 输入
 * 第一行三个整数n，k，m。(1≤n≤100),(1≤k≤100),(0≤m≤2e9)
 *
 * 第二行两个整数p，q。(1≤p,q≤100)
 *
 * 第三行k个整数表示每个子任务需要的时间。(1≤ ti≤1e6)
 *
 * 输出
 * 输出在m的时间内能获得的最大得分。
 *
 *
 * 样例输入
 * 3 2 8
 * 3 1
 * 9 5
 * 样例输出
 * 3
 *
 * 提示
 * 输入样例
 * 2 2 3
 * 1 2
 * 1 1
 *
 * 输出样例
 * 5
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int[] test = new int[k];
        for(int i=0; i<k; i++){
            test[i] = sc.nextInt();
        }

        System.out.println("n: "+n+" k: "+k+" m: "+m);
        System.out.println("p: "+p+" q: "+q);
        System.out.println(test[0]+" : "+test[1]);
        /**
         * 解题思路：
         *  需要使用动态规划来做，但是我没有找到合适的dp数组
         */
    }
}
