package com.zxh.algorithms.experiment.first;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */

/**
 * 在一个连通分量的所有触点在id[i]中的值都是一样的；
 */
public class QuickFind {
    private int count;
    private int[] id;
    public QuickFind(int N){
        count = N;
        id = new int[N];
        //赋值初始值，整个数组的初始值为下标值
        for(int i=0;i<N;i++) id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean isConnected(int p,int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p,int q) {
        int pid = find(p);
        int qid = find(q);
        if(pid == qid) return;
        //需要去遍历整个数组找到对应的位置将两元素的值修改一样
        for(int i = 0 ; i < id.length ; i++)
            if(id[i] == pid)    id[i] = qid;
        count--;
    }

}
