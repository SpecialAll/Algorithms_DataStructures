package com.zxh.leetcode.byteDance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述：
 *  班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 示例 2:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 注意：
 *
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 *
 *
 * 解题思路：
 *
 *  第一种解答：
 *      采用深度优先搜寻
 *
 *  第二种解答：
 *      采用广度优先遍历
 *
 *  第三种解答：
 *      采用并查集
 */
public class FindCircleNum {
    //采用深度优先遍历
    public int findCirleNum(int[][] M){
        int[] visited = new int[M.length];
        int count = 0;
        for(int i=0; i<M.length; i++){
            if(visited[i] == 0){
                dfs(visited, M, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[] visited, int[][] m, int i) {
        for(int j=0; j<m.length; j++){
            if(visited[j] == 0 && m[i][j] == 1){
                visited[j] = 1;
                dfs(visited,m,j);
            }
        }
    }

    //采用广度优先遍历
    public  int findCircleNum2(int[][] M){
        int[] visitied = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<M.length; i++){
            if(visitied[i] == 0){
                queue.add(i);
                while(!queue.isEmpty()){
                    int s = queue.remove();
                    visitied[s] = 1;
                    for(int j=0; j<M.length; j++){
                        if(M[s][j] == 1 && visitied[j] == 0){
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println("朋友圈为："+new FindCircleNum().findCirleNum(M));
    }
}

