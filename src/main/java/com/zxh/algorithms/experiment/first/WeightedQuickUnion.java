package com.zxh.algorithms.experiment.first;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */

/**
 * 我们在findUnion的基础上发展来的QuickUnion就是为了减少数组访问的次数，
 * 但是我们发现QuickUnion如果在最坏的情况下它可能会成为一个先行结构的树，这样的话也就不能减少访问次数，
 * 所以在这里进一步的算法分析：
 *  使用权重的树结构，每次都是将小树union到大树上，从而使整个树更加合理；
 */
public class WeightedQuickUnion {
    private int count;
    private int[] id;
    private int[] sz;
    public WeightedQuickUnion(int N){
        count = N;
        id = new int[N];
        sz = new int[N];
        for(int i=0;i<N;i++) id[i] = i;
        for(int i=0;i<N;i++) sz[i] = 1;  //权重开始赋值为i
    }
    public int count() {
        return count;
    }

    public boolean isConnected(int p,int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while(p !=id[p])  p = id[p];
        return p;
    }

    public void union(int p,int q) {
        int i = find(p);
        int j = find(q);
        if( i == j ) return;
        //这一步就是将小树放置到大树的触点上
        if(sz[i] < sz[j])  { id[i] = j; sz[i] += sz[i];	}
        else  { id[j] = i ; sz[i] += sz[j]; }
        count--;
    }
}

