package com.zxh.algorithms.experiment.first;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */

import java.util.Scanner;
public class PercolateStatistics {
    private int matrixlength;
    private double prob[];
    private double average;
    private double pcl_mean;
    private double pcl_stddev;

    public PercolateStatistics(int N,int T,int t) {
        matrixlength = N;
        double prob[] = new double[T];
        for(int i=0;i<T;i++) {
            Percolate_problem percolation = new Percolate_problem(N,t);
            int count=0;
            //percolation.isPercolated(t) 如果顶部虚拟节点和底部虚拟节点联通，则循环结束
            while(!percolation.isPercolated(t)) {
                //System.out.print(t);
                int row=(int)(Math.random()*matrixlength)+1;
                int column=(int)(Math.random()*matrixlength)+1;
                //随机找到一个位置，如果是true则代表已经进行过open操作
                if(percolation.isOpen(row, column))
                    continue;
                else {
                    //如果不连通，则构成更大的连通分量
                    percolation.open(row, column,t);
                    count++;
                }
            }
            //Count代表达到连通使需要的连通分量
            prob[i] = (double)count/(matrixlength*matrixlength);
            pcl_mean=mean(prob);
            pcl_stddev=Stddev(prob);

        }
    }

    public double getPercolateMean() {
        return pcl_mean;
    }
    public double getPercolateSteddev() {
        return pcl_stddev;
    }


    //求加权值
    public double Stddev(double prob[]) {
        double sum=0.0,stddev;
        for(int i=0;i<prob.length;i++) sum += (prob[i] - pcl_mean)*(prob[i] - pcl_mean);
        stddev = Math.sqrt(sum/(prob.length-1));
        return stddev;
    }

    public double mean(double prob[]){
        double sum=0;
        for(int i=0;i<prob.length;i++)
            sum += prob[i];
        return sum/prob.length;
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("please input N and T");
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            int T = in.nextInt();
            long starttime = System.currentTimeMillis();
            PercolateStatistics p = new PercolateStatistics(N,T,4);
            long endtime = System.currentTimeMillis();
            long runningtime = endtime - starttime;
            System.out.println("the mean value of percolation probablity is "+p.getPercolateMean());
            System.out.println("the standard deviation is "+ p.getPercolateSteddev());   //错误偏离值
            System.out.println("the total running time  of CompressedQuickUnion is " + runningtime + "ms" );


            starttime = System.currentTimeMillis();
            p = new PercolateStatistics(N,T,1);
            endtime = System.currentTimeMillis();
            runningtime = endtime - starttime;
            System.out.println("the total running time  of WeightedQuickUnion is " + runningtime + "ms" );


            starttime = System.currentTimeMillis();
            p = new PercolateStatistics(N,T,2);
            endtime = System.currentTimeMillis();
            runningtime = endtime - starttime;
            System.out.println("the total running time  of QuickUnion is " + runningtime + "ms" );

            starttime = System.currentTimeMillis();
            p = new PercolateStatistics(N,T,3);
            endtime = System.currentTimeMillis();
            runningtime = endtime - starttime;
            System.out.println("the total running time  of QuickFind is " + runningtime + "ms" + '\n' + '\n');
        }
    }

}


