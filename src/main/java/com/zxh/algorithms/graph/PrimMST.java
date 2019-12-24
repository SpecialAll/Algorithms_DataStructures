package com.zxh.algorithms.graph;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/24
 */
public class PrimMST {
    /**
     * 这里使用即时方法实现prim算法，生成最小生成树
     * 该方法和延时版本的不同之处在于，延时版本的prim算法是将所有的切分边（包括失效边）都添加到优先队列中去；
     * 所以在这里我们做的优化就是将一些无效边删除，在边添加时，只需要将有效边比较添加；
     *
     * 换句话说就是：我们只会在优先级队列中保存每一个非树顶点w的一条边：将它在树中的顶点连接起来的权重最小的那条边；
     *
     * 将Lazy方式中的marked【】 和mst[]替换为两个顶点索引的数组edgeTo[] 和 distTo【】，有如下性质：
     *      1、如果顶点v不在树中但至少包含一条边和树相连，那么edgeTo[v]是将v和树连接的最短边，distTo[v]为这条边的权重；
     *      2、所有这类顶点v都保存在一条索引优先队列中，索引v关联的值是edgeTo[v]的边的权重；
     *   关键点在于:优先队列中的最小值既是权重最小的横切边的权重，而和它关联的顶点v就是下一个被添加到树中的顶点；
     *
     *
     *      private boolean【】 marked;  //表示最小生成树的顶点
     *      private Edge【】 edgeTo;   //表示最小生成树的边
     *      private double【】 distTo;   //边的权重
     *      private IndexMinPQ<Double> pq;    //有效横向边
     *
     *      public LazyPrimMST（EdgeWeightedGroup G){
     *          edgeTo = new Edge【G.v()];
     *          marked = new boolean[G.v()];
     *          distTo = double[G.v()];
     *          for(int v=0; v<G.v(); v++)
     *              distTo[v] = Double.POSITIVE_INFINITY;
     *          pq = new IndexMinPQ<Double>(G.v());
     *
     *          distTo[0] = 0.0;
     *          pq.insert(0, 0.0);   //初始化pq
     *          while(!pq.isEmpty()){
     *               visited(G, pq.delMin());
     *          }
     *      }
     *      *
     *      private void visit(EdgeWeightedGroup G, int v){
     *          //标记顶点v，并将所有连接v和未被标记顶点的边加入到pq;
     *          marked[v] = true;
     *          for(Edge e : G.adj[v]){
     *              int w = e.other[v];
     *
     *             if(marked[w]) continue;
     *              if(e.weight() < distTo[w]){
     *                  edgeTo[w] = e;
     *
     *                  distTo[w] = e.weight();
     *                  if(pq.contains(w)) pq.change(w, distTo(w));
     *                  else   pq.insert(w, distTo(w));
     *              }
     *          }
     *      }
     */
}
