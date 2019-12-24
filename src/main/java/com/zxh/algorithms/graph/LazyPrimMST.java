package com.zxh.algorithms.graph;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/24
 */
//prim算法生成最小生成树
public class LazyPrimMST {
    /**
     * 这里使用prim算法的延时实现方法
     * 这里说一下该算法：
     *  prim算法它是将一条边一条边添加进子树，再不会构成环的前提下；
     *  它是在横向切分的基础上来找合适的边；
     *
     * lazy实现方式：它是将所有的切分边都添加到优先队列中
     *
     * private boolean【】 marked;  //表示最小生成树的顶点
     * private Queue<Edge> mst;   //表示最小生成树的边
     * private MinPQ<Edge> pq;    //横向边（包括失效边）
     *
     * public LazyPrimMST（EdgeWeightedGroup G){
     *     pq = new MinPQ<Edge>();
     *     marked = new boolean[G.v()];
     *     mst = new Queue<Edge>();
     *
     *     vistit(G, 0);  //将O顶点添加到优先队列中
     *     while(!pq.isEmpty()){
     *          Edge e = pq.delMin();   //从pq中得到权重最小的边
     *          int v = e.either(), w = e.other(v);
     *          if(marked[v] && marked[w]) continue;
     *          mst.enqueue(e);     //将边添加到树中
     *          if(!marked[v]) visit(G, v);
     *          if(!marked[w])  visited(G, w);
     *     }
     * }
     *
     * private void visit(EdgeWeightedGroup G, int v){
     *     //标记顶点v，并将所有连接v和未被标记顶点的边加入到pq;
     *     marked[v] = true;
     *     for(Edge e : G.adj[v]){
     *         if(!marked[e.other(v)])
     *              pq.insert(e);
     *     }
     * }
     */
}
