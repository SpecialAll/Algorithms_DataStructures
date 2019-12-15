package com.zxh.algorithms.experiment.first;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */

/**
 * 该算法是在findUnion的基础上提升union速度而产生的：
 *  我们将一个连通分量定义为拥有公共的根节点便是同一个连通分量，
 *  也就是说我们需要去循环直到某节点的值和下标值一样就意味着它是根节点
 */
public class QuickUnion {
    //count代表连通分量的个数
    private int count;
    private int[] id;
    public QuickUnion(int N){
        count = N;
        id = new int[N];
        for(int i=0;i<N;i++) id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean isConnected(int p,int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        //注意这里的while循环
        while(p != id[p])  p = id[p];
        return p;
    }

    public void union(int p,int q) {
        int pRoot = find(p);  //寻找根节点
        int qRoot = find(q);
        if(pRoot == qRoot) return;

        id[pRoot] = qRoot;
        count--;
    }


}

