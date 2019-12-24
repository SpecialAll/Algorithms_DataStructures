package com.zxh.algorithms.graph;

import com.zxh.algorithms.experiment.third.DirectedEdge;
import com.zxh.algorithms.experiment.third.EdgeWeightedDigraph;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/24
 */
//克鲁斯卡尔算法求最小生成树
public class KruskalMST {
    /**
     * 由于很多类没有写，所以在这里写一下伪代码
     * 该算法的本质其实和prim算法差不多，都是将边添加进来然后去判断当前边是否满足最小生成树的要求，
     * 而该算法的不同之处在于：它做的是将两个单点子树连接起来，用权重最小的边连接起来；
     * 通过一个优先级队列来将边权重进行排序；
     *
     * private Queue<Edge> mst;
     * public KruskalMST(EdgeWeightedGraph G){
     *     mst = new Queue<>();
     *     MinPQ<Edge> pq = new MinPQ<Edge>();
     *     for(Edge e : G.edges())
     *          pq.insert(e);  //将所有边添加到优先队列中去；
     *     UF uf = new UF(G.V());
     *
     *     while(!pq.isEmpty() && mst.size() < G.v() - 1){
     *          Edge e = pq.delMin();
     *          int v = e.either(), w = e.other(v);
     *          if(uf.connected(v, w))  //忽略无效边，也就是已经连通的边！
     *               continue;
     *          uf.union(v, w);   //将这两个点构成连通分量！
     *          mst.enqueue(e);
     *     }
     * }
     */

}
