package com.zxh.algorithms.experiment.first;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */
import java.util.Random;
public class Percolate_problem {
    private boolean[] matrix;
    private int matrixlength;
    private WeightedQuickUnion uf1;
    private QuickUnion uf2;
    private QuickFind uf3;
    private CompressedWeightedQuickUnion uf4;
    private int vrtop;
    private int vrbottom;

    public Percolate_problem(int N, int i) {
        matrix = new boolean[N*N];
        matrixlength = N;
        if(i == 1)    uf1 = new WeightedQuickUnion(N*N+2);
        else if(i == 2) uf2 = new QuickUnion(N*N+2);
        else if(i == 3) uf3 = new QuickFind(N*N+2);
        else uf4 = new CompressedWeightedQuickUnion(N*N+2);
        vrtop = matrixlength*matrixlength;
        vrbottom = vrtop+1;
    }

    public int matrixToOneDemension(int row,int column) {

        return (row - 1) * matrixlength + column - 1;
    }

    public boolean isOpen(int row,int column) {
        return matrix[matrixToOneDemension(row,column)];
    }

    public void open(int row,int column, int t) {
        //四种算法的不同union操作，
        if(t == 1) {
            //1、WeightedQuickUnion算法
            int place = matrixToOneDemension(row,column);
            if(matrix[place])  return;

            matrix[place] = true;

            if(row == 1)  uf1.union(place,vrtop);
            if(row == matrixlength)  uf1.union(place,vrbottom);
            if(row>1) {
                int neighbor;
                neighbor = matrixToOneDemension(row-1,column);
                if(matrix[neighbor]) uf1.union(place,neighbor);
            }
            if(row<matrixlength) {
                int neighbor;
                neighbor = matrixToOneDemension(row+1,column);
                if(matrix[neighbor]) uf1.union(place,neighbor);
            }
            if(column>1) {
                int neighbor;
                neighbor = matrixToOneDemension(row,column-1);
                if(matrix[neighbor]) uf1.union(place,neighbor);
            }
            if(column<matrixlength) {
                int neighbor;
                neighbor = matrixToOneDemension(row,column+1);
                if(matrix[neighbor]) uf1.union(place,neighbor);
            }
        }

        else if(t == 2) {
            int place = matrixToOneDemension(row,column);
            if(matrix[place])  return;

            matrix[place] = true;

            if(row == 1)  uf2.union(place,vrtop);
            if(row == matrixlength)  uf2.union(place,vrbottom);
            if(row>1) {
                int neighbor;
                neighbor = matrixToOneDemension(row-1,column);
                if(matrix[neighbor]) uf2.union(place,neighbor);
            }
            if(row<matrixlength) {
                int neighbor;
                neighbor = matrixToOneDemension(row+1,column);
                if(matrix[neighbor]) uf2.union(place,neighbor);
            }
            if(column>1) {
                int neighbor;
                neighbor = matrixToOneDemension(row,column-1);
                if(matrix[neighbor]) uf2.union(place,neighbor);
            }
            if(column<matrixlength) {
                int neighbor;
                neighbor = matrixToOneDemension(row,column+1);
                if(matrix[neighbor]) uf2.union(place,neighbor);
            }
        }

        else if(t == 3) {
            int place = matrixToOneDemension(row,column);
            if(matrix[place])  return;

            matrix[place] = true;

            if(row == 1)  uf3.union(place,vrtop);
            if(row == matrixlength)  uf3.union(place,vrbottom);
            if(row>1) {
                int neighbor;
                neighbor = matrixToOneDemension(row-1,column);
                if(matrix[neighbor]) uf3.union(place,neighbor);
            }
            if(row<matrixlength) {
                int neighbor;
                neighbor = matrixToOneDemension(row+1,column);
                if(matrix[neighbor]) uf3.union(place,neighbor);
            }
            if(column>1) {
                int neighbor;
                neighbor = matrixToOneDemension(row,column-1);
                if(matrix[neighbor]) uf3.union(place,neighbor);
            }
            if(column<matrixlength) {
                int neighbor;
                neighbor = matrixToOneDemension(row,column+1);
                if(matrix[neighbor]) uf3.union(place,neighbor);
            }
        }

        else if(t == 4) {
            int place = matrixToOneDemension(row,column);
            if(matrix[place])  return;

            matrix[place] = true;

            if(row == 1)  uf4.union(place,vrtop);
            if(row == matrixlength)  uf4.union(place,vrbottom);
            if(row>1) {
                int neighbor;
                neighbor = matrixToOneDemension(row-1,column);
                if(matrix[neighbor]) uf4.union(place,neighbor);
            }
            if(row<matrixlength) {
                int neighbor;
                neighbor = matrixToOneDemension(row+1,column);
                if(matrix[neighbor]) uf4.union(place,neighbor);
            }
            if(column>1) {
                int neighbor;
                neighbor = matrixToOneDemension(row,column-1);
                if(matrix[neighbor]) uf4.union(place,neighbor);
            }
            if(column<matrixlength) {
                int neighbor;
                neighbor = matrixToOneDemension(row,column+1);
                if(matrix[neighbor]) uf4.union(place,neighbor);
            }
        }
    }

    public boolean isPercolated(int t) {
        if(t == 1)  return uf1.isConnected(vrtop,vrbottom);
        else if(t == 2)  return uf2.isConnected(vrtop,vrbottom);
        else if(t == 3)  return uf3.isConnected(vrtop,vrbottom);
        else   return uf4.isConnected(vrtop,vrbottom);

    }


}

