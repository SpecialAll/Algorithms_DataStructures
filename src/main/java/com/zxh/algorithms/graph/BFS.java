package com.zxh.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/30
 *
 * 广度优先遍历
 */
public class BFS {
    /**
     * 广度优先遍历会使用队列作为辅助数据结构
     */
    private void broadFirstSearch(Graph graph, int v){
        Queue<Integer> queue = new LinkedList<>();
        //将遍历到的v压入队列
        queue.add(v);
        graph.isVisited[v] = true;
        System.out.println("遍历到了"+v+"节点");
        while (!queue.isEmpty()){
            //弹出队首的元素
            Integer head = queue.poll();
            //获取队首元素的第一个邻接点
            int FN = graph.getFirstNeighbor(v);
            while (FN != -1){
                if(!graph.isVisited[FN]){
                    graph.isVisited[FN] = true;
                    System.out.println("遍历到了"+FN+"节点");
                    queue.add(FN);
                }
                //遍历队首元素的邻接点
                FN = graph.getNextNeighbor(head, FN);
            }
        }
    }

    //暴露的方法
    public void broadFirstSearch(Graph graph){
        for (int i=0; i<graph.vertexSize; i++){
            if(!graph.isVisited[i]){
                broadFirstSearch(graph, i);
            }
        }
    }
}
