package com.zxh.algorithms.graph;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/30
 *
 * 图的深度优先遍历
 */
public class DFS {
    //从顶点v开始遍历
    private void depthFirstSearch(Graph graph, int v){
        //将遍历的节点标记为true
        graph.isVisited[v] = true;
        //遍历顶点的第一个邻接点
        int FN = graph.getFirstNeighbor(v);
        while (FN != -1){ //如果第一个邻接点存在
            if(!graph.isVisited[FN]) {  //并且没有被访问过
                System.out.println("遍历到了"+FN+"节点");
                //同时递归遍历该节点的邻接点
                depthFirstSearch(graph, FN);
            }
            //如果第一个节点已经被访问过了，就访问该节点的邻接点
            FN = graph.getNextNeighbor(v, FN);
        }
    }

    //对外暴露的方法
    public void depthFirstSearch(Graph graph){
        for (int i=0; i<graph.vertexSize; i++){
            if(!graph.isVisited[i]){
                System.out.println("遍历到了"+i+"节点");
                depthFirstSearch(graph, i);
            }
        }
    }
}
