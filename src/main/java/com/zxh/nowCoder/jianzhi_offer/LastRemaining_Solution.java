package com.zxh.nowCoder.jianzhi_offer;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/2/19
 */

/**
 * 题目描述
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,
 * 哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 *
 *
 * 题目解析：
 * 用数组模拟环来解决
 */
public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1)
            return -1;
        int[] array = new int[n];
        // count 记录当前环中还有多少学生  i 代表当前环的下标位置  step 记录当前走过的路径，用于判断到达的学生数字
        int count = n, i = -1, step = 0;
        while(count >0){
            i ++;
            if(i >= n){
                i = 0;  //如果到达了环的末端就将其再次放到环的第一个位置
            }
            if(array[i] == -1)
                continue;  //如果是-1 ，则表示已经走过了，跳过
            step++;
            if(step == m){  //找到了待删除的数字
                array[i] = -1;
                step = 0;
                count--;
            }
        }
        return i;  //循环退出意味着环结束了，最后一个位置也会被修改为-1
    }
}
