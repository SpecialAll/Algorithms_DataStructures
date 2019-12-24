package com.zxh.algorithms.experiment.third;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EdgeWeightedDigraph {
    private int V;  //顶点个数
    private int E;  //边的总数
    private Bag<DirectedEdge>[] adj;  //邻接表
    public int test;
    private int source;
    private int coordinate[][];  //二维数组存储节点坐标
    public EdgeWeightedDigraph() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            String str = "";
            fis = new FileInputStream("/home/ningque/Java/use.txt");
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            str = br.readLine();
            String[] numbersArray=str.split(" ");
            this.V = Integer.parseInt(numbersArray[0]);
            this.E = Integer.parseInt(numbersArray[1]);

            adj = (Bag<DirectedEdge>[]) new Bag[V];  //adj数组
            for(int v = 0 ; v < V ; v++) adj[v] = new Bag<DirectedEdge>();   //每个adj数组节点都有一个链表
            coordinate = new int[this.V][2];
            int count = 0;
            while (count < this.V && (str = br.readLine()) != null  ) {
                String str1 = str.trim();
                String[] numbersArray1=str1.split("\\s+");
                int a = Integer.parseInt(numbersArray1[0]);
                int b = Integer.parseInt(numbersArray1[1]);
                int c = Integer.parseInt(numbersArray1[2]);
//                System.out.print(a);
//                System.out.print(b);
//                System.out.print(c);

                //代表一个节点a，坐标为(b,c)
                coordinate[a][0] = b;
                coordinate[a][1] = c;
                count++;

            }
            count = 0;
            System.out.println("\n");
            str = br.readLine();
            while (count < this.E &&(str = br.readLine()) != null) {
                count++;
                String str1 = str.trim();
                String[] numbersArray2=str1.split("\\s+");
//                System.out.print(numbersArray2[0]);
//                System.out.print(numbersArray2[1]);
                int a = Integer.parseInt(numbersArray2[0]);
                int b = Integer.parseInt(numbersArray2[1]);
                int a_x = coordinate[a][0];  //a顶点的横坐标
                int a_y = coordinate[a][1];  //a顶点的纵坐标
                int b_x = coordinate[b][0];
                int b_y = coordinate[b][1];
                double abs_x = Math.abs(a_x - b_x);
                double abs_y = Math.abs(a_y - b_y);
                double distance = Math.sqrt(abs_x * abs_x + abs_y * abs_y);
                DirectedEdge e = new DirectedEdge(a,b,distance);  //构建一条有向边
                this.addEdge(e);
            }
            //	System.out.println();
            //	str = br.readLine();
            //	String str1 = str.trim();
            //	String[] numbersArray3=str1.split("\\s+");
            //	this.source = Integer.parseInt(numbersArray3[0]);
        }
        catch (IOException e) {
            System.out.println("读取文件失败！");
        }
        finally {
            try {
                br.close();
                isr.close();
                fis.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int V() {	return V;	}

    public int E() {	return E;	}

    public int getSource() {    return source;    }

    //添加有向边到邻接表中
    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
    }

    public Iterable<DirectedEdge> adj(int v)  {    return adj[v];    }

    /*public static void main(String args[]) {
		EdgeWeightedDigraph d = new EdgeWeightedDigraph();
		System.out.println(d.V() );
		System.out.println(d.E() );
		System.out.println(d.getSource());

	}*/



}

