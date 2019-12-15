package com.zxh.algorithms.experiment.third;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */

public class DirectedEdge {
    private int from;   //起始节点
    private int to;     //目的节点
    private double weight;   //权重
    public DirectedEdge(int from , int to , double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    public double weight() {
        return weight;
    }
    public int to() {
        return to;
    }
    public int from() {
        return from;
    }


}

