package com.zxh.algorithms.experiment.third;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */
import java.util.Scanner;

public class Dijkstra {
    private DirectedEdge[] edgeTo;
    private double distTo[];   //代表S到当前节点的最小权重
    private IndexMinPQ pq;

    public Dijkstra(EdgeWeightedDigraph G, int s, int to) {
        edgeTo = new DirectedEdge[G.V()];   //邻接表结构 一共V节点个
        distTo = new double[G.V()];
        pq = new IndexMinPQ(G.V());
        for(int v = 0; v < G.V(); v++) distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0;
        pq.insert(s,0.0);
        while(!pq.isEmpty())  {
            int a = pq.delMin();
            //当当前节点是目标节点时，表示当前最短路径找到，跳出循环
            if(a == to)  break;
            //将当前节点放松
            relax(G , a, to);
        }
    }

    public void relax(EdgeWeightedDigraph G , int v , int to){
        for(DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if(distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;  //将e该条邻接边添加到以w为起点的邻接数组中
                if(pq.contains(w)) pq.change(w , distTo[w]);
                else   pq.insert(w , distTo[w]);

            }

        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public static void main(String args[]) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph();
        //System.out.print("b");
        while(true) {
            Scanner input1=new Scanner(System.in);
            System.out.println("input start");
            int from=input1.nextInt();
            Scanner input2=new Scanner(System.in);
            System.out.println("input end");
            int to=input2.nextInt();
            long timeStart = System.currentTimeMillis();
            Dijkstra d = new Dijkstra(g,from,to);
            System.out.println("the shortest distance between the two node is " + d.distTo(to));
            long timeEnd = System.currentTimeMillis();
            long timeInterval = timeEnd - timeStart;
            System.out.println("the running time is "+timeInterval+"ms"+"\n");
        }
    }


}

