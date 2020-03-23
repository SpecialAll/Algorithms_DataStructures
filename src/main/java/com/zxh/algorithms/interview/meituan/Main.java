package com.zxh.algorithms.interview.meituan;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/19
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 扎银花
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 *       扎金花是一种非常受欢迎的纸牌游戏。而在游戏界有一种于扎金花类似的玩法，叫做扎银花。
 *
 *       相比于扎金花的牌型多变，扎银花就简单多了，虽然同样是三张牌比大小，在扎银花的规则里只需要把三张牌的点数相加再进行大小比较即可，点数大的人获胜。
 *
 *       今天我们玩的不是扑克牌，而是一种取值范围在1-10^9以内的简单牌，两个人一开始各自有n张牌，他们会想办法组合出最大的牌，请你计算出获胜的一方的三张牌的点数之和。
 *
 * 输入
 *         输入第一行仅包含一个正整数n，代表双方掌握的牌的数量。(1<=n<=20000)
 *
 *         接下来有2行,每行有n个数字，分别代表双方可选的n张牌。
 *
 * 输出
 *         输出仅包含一个正整数，即获胜的一方的最大牌型的点数之和，当然是可能有平局的，此时答案也是唯一的。
 *
 *
 * 样例输入
 * 5
 * 1 2 3 4 5
 * 1 2 3 4 6
 * 样例输出
 * 13
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        char[] ch = n.toCharArray();
        int num = ch[0] - '0';
        if(num == 0)
            System.out.println(0);
        ArrayList<Integer> list1 = new ArrayList<>();
        String str = sc.nextLine();
        char[] ch2 = str.toCharArray();
        for(int i=0; i<ch2.length; i++){
            if(ch2[i] != ' '){
                list1.add(ch2[i]-'0');
            }
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        String str2 = sc.nextLine();
        char[] ch3 = str2.toCharArray();
        for(int i=0; i<ch3.length; i++){
            if(ch3[i] != ' '){
                list2.add(ch3[i]-'0');
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        int len1 = list1.size();
        int len2 = list2.size();
        int max1 = list1.get(len1-1) + list1.get(len1-2) + list1.get(len1-3);
        int max2 = list2.get(len2-1) + list2.get(len2-2) + list2.get(len2-3);

        System.out.println(max1 > max2 ? max1 : max2);

    }
}
