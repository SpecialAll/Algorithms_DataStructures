package com.zxh.algorithms.interview.meituan;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/19
 */

/**
 * 跑步计划
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 晨晨是个爱跑步的孩子，这一天，他准备跑正好k米。他所在的城市的道路可以看做n个点，m条无向边组成的图，每条边有一个固定的长度。
 *
 * 晨晨有强迫症，他跑步前往一个目的地一定要走最短路（当然有多条最短路就可以随意选择了）。
 *
 * 晨晨希望知道，他正好跑k米能走到的目的地的个数。注意，目的地可能在图中的点和边上，且该目的地距离晨晨的起点的最短路正好k米。
 *
 * 若k大于所有路径之和自然不存在这样的目的地，输出结果自然为0。
 *
 * 输入
 * 第一行输入三个数,n,m,s代表图中的点数，边数，以及晨晨的起点的编号
 *
 * 接下来m行，每行3个数u,v,w描述一条无向边，代表点u到点v有一条无向边，长度为w。
 *
 * 接下来一行一个数k，描述晨晨希望跑的距离。
 *
 * 输出
 * 输出一个数，代表不同的目的地个数。
 *
 *
 * 样例输入
 * 3 3 1
 * 1 2 2
 * 2 3 3
 * 1 3 4
 * 4
 * 样例输出
 * 2
 *
 * 提示
 * 对于30%的数据 n,m≤100
 * 对于100%的数据 0≤n,m≤100000 , 0≤w≤1000 , 1≤k≤10^9 , 1≤u,v≤n
 *
 * 例如：晨晨希望跑4米，他可以沿着第三条边直接跑向3号节点，此时跑步距离为4。
 * 他也可以先跑第一条边2米，再跑第二条边2米，停在第二条边的中间2/3的位置。可以证明，这两个目的地到1号节点的最短路都为4
 */
public class Test4 {
    public static void main(String[] args) {
        /**
         * 解题思路：
         * max记录可达的目的数
         * 1、首先判断该无向图中所有的变长和是否小于晨晨所跑的长度，若小则返回0；
         * 2、通过广度优先遍历，寻找最短路径，将寻找到的路径数记录在max中，选择一条去走，走过之后减去该路径长度，
         *      如果跑完则返回max值；
         *      如果没跑完则从当前节点出发再次寻找最短路径，重复步骤二
         *
         * 注意：这里的max值等于  当前路径数 × 上一层最短路径数（排列组合问题）
         */
    }
}
