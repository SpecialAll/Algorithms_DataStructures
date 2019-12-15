package com.zxh.algorithms.experiment.first;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */

/**
 * 这个算法的初衷便是希望可以减少链接修改的次数，将每个节点的值都直接修改为根节点
 */
public class CompressedWeightedQuickUnion {
    private int count;
    private int[] id;
    private int[] sz;
    public CompressedWeightedQuickUnion(int N){
        count = N;
        id = new int[N];
        sz = new int[N];
        for(int i=0;i<N;i++) id[i] = i;
        for(int i=0;i<N;i++) sz[i] = 1;
    }
    public int count() {
        return count;
    }

    public boolean isConnected(int p,int q) {
        return find(p) == find(q);
    }

    public int find(int i) {
        //这里和QuickUnion的最大区别就是这里的循环是将当前节点位置的值修改为根节点，而QuickUnion只是找到根节点
        while(i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public void union(int p,int q) {
        int i = find(p);
        int j = find(q);
        if( i == j ) return;
        if(sz[i] < sz[j])  { id[i] = j; sz[i] += sz[i];	}
        else  { id[j] = i ; sz[i] += sz[j]; }
        count--;
    }

}

