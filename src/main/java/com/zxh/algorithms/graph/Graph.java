package com.zxh.algorithms.graph;


/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/30
 *
 * 图的表示类
 */
public class Graph {
    //-------------------图的表示方式-----------------
    public int vertexSize; //顶点数量
    public int[] vertexs; //顶点对应的数组
    public int[][] matrix; //邻接矩阵
    private static final int MAX_WEIGHT = 1000; //代表顶点之间不连通
    public boolean[] isVisited; //顶点是否已被访问

    public Graph(int vertexSize){
        this.vertexSize = vertexSize;
        this.matrix = new int[vertexSize][vertexSize];
        this.vertexs = new int[vertexSize];
        for(int i=0; i<vertexSize; i++){
            vertexs[i] = i;
        }

        isVisited = new boolean[vertexSize];
    }

    //-------------两个重要的方法-----------------------
    //获取某一个顶点的第一个邻接点
    public int getFirstNeighbor(int index){
        for (int i=0; i<vertexSize; i++){
            if(matrix[index][i] > 0 && matrix[index][i] != 1000){
                return i;
            }
        }
        //如果没有第一个邻接点就返回-1
        return -1;
    }

    //获取当前节点V的邻接点index的下一个邻接点
    public int getNextNeighbor(int v, int index){
        for(int i=index+1; i<vertexSize; i++){
            if(matrix[v][i] > 0 && matrix[v][i] != 1000){
                return i;
            }
        }
        return -1;
    }
}
