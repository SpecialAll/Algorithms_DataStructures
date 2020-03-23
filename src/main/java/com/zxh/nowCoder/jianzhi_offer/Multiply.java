package com.zxh.nowCoder.jianzhi_offer;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/19
 */

/**
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */
public class Multiply {
    /**
     * B[i]的值可以看作下图的矩阵中每行的乘积。
     * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
     * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。
     * 参考resources中的图片！
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int[] ans = new int[A.length];
        if(A.length != 0){
            ans[0] = 1;
            for(int i=1; i<A.length; i++){
                ans[i] = ans[i-1] * A[i-1];
            }
            int temp = 1;
            for(int j=A.length-2; j>=0; j--){
                temp *= A[j+1];
                ans[j] *= temp;
            }
        }
        return ans;
    }
}
