package com.zxh.algorithms.graph;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/30
 */
public class GraphMain {
    private static final int MAX_WEIGHT = 1000; //代表顶点之间不连通
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        int[] v0 = { 0, 4, MAX_WEIGHT, 7, 2, MAX_WEIGHT };
        int[] v1 = { MAX_WEIGHT, 0, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 3 };
        int[] v2 = { MAX_WEIGHT, 9, 0, 5, 6, MAX_WEIGHT };
        int[] v3 = { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0, MAX_WEIGHT, MAX_WEIGHT };
        int[] v4 = { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0, MAX_WEIGHT };
        int[] v5 = { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 1, 0 };

        graph.matrix[0] = v0;
        graph.matrix[1] = v1;
        graph.matrix[2] = v2;
        graph.matrix[3] = v3;
        graph.matrix[4] = v4;
        graph.matrix[5] = v5;

        //采用DFS
        DFS dfs = new DFS();
        dfs.depthFirstSearch(graph);

//        System.out.println("\n------------------------------------------\n");
//        //BFS
//        BFS bfs = new BFS();
//        bfs.broadFirstSearch(graph);
    }
}
