package com.zxh.algorithms.experiment.third;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */
import java.util.Arrays;
import java.util.NoSuchElementException;

public class IndexMinPQ {
    private int N;
    private int[] pq;
    private int[] qp;
    private double[] keys;

    public IndexMinPQ(int maxN) {
        keys =  new double[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        Arrays.fill(qp, -1);
    }


    private boolean greater(int i, int j) {
        return keys[pq[i]] -keys[pq[j]] > 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void insert(int k, double key) {
        if (!contains(k)) {
            N++;
            pq[N] = k;
            qp[k] = N;
            keys[k] = key;
            swim(N);
        }
    }


    public void change(int k, double key) {
        keys[k] = key;
        swim(qp[k]);  //修改当前最小值
        sink(qp[k]);
    }


    public double min() {
        return keys[pq[1]];
    }


    public int minIndex() {
        return pq[1];
    }

    public int delMin() {
        int indexOfMin = pq[1];
        swap(1, N--);
        sink(1);
        keys[indexOfMin] = 0;

        qp[indexOfMin] = -1;

        return indexOfMin;
    }

    public void delete(int k) {
        int index = qp[k];

        swap(index, N--);

        swim(index);
        sink(index);
        keys[k] = 0;
        qp[k] = -1;
    }

    public double keyOf(int k) {
        if (contains(k)) {
            return keys[k];
        }
        return 0;
    }

    private void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }
}

