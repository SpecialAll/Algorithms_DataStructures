package com.zxh.algorithms.sort;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/24
 */
//希尔排序，其实内部还是使用插入排序来做的！
public class Shell {
    public void sort(char[] a){
        //将a按照升序进行排序
        int N = a.length;
        int h = 1;
        while(h < N/3)
            h = 3*h + 1;
        while(h >= 1){
            //将数组变为h有序
            for(int i=h; i<N; i++){
                //将a[i] 插入到 a[i-h] a[i-2*h] a[i-3*h]....
                for(int j=i; j>=h && a[j] < a[j-h]; j -= h){
                    char temp = a[j];
                    a[j] = a[j-h];
                    a[j-h] = temp;
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        char a[] = {'S','H','E','L','L','S','O','R','T','E','X','A','M','P','L','E'};
        shell.sort(a);
        System.out.println(a);
    }
}
