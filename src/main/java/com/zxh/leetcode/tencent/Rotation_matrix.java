package com.zxh.leetcode.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
   题目描述：
      给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

        示例:

        输入: 3
        输出:
        [
         [ 1, 2, 3 ],
         [ 8, 9, 4 ],
         [ 7, 6, 5 ]
        ]

    思路：
       思路：
        生成一个 n×n 空矩阵 mat，随后模拟整个向内环绕的填入过程：
            定义当前左右上下边界 l,r,t,b，初始值 num = 1，迭代终止值 tar = n * n；
            当 num <= tar 时，始终按照 从左到右 从上到下 从右到左 从下到上 填入顺序循环，每次填入后：
                执行 num += 1：得到下一个需要填入的数字；
                更新边界：例如从左到右填完后，上边界t += 1，相当于上边界向内缩 1。
            使用num <= tar而不是l < r || t < b作为迭代条件，是为了解决当n为奇数时，矩阵中心数字无法在迭代过程中被填充的问题。
        最终返回 mat 即可。


*/
class Solution59 {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }
}

public class Rotation_matrix {
    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
            //sb.append(Integer.toString(item));  此步一直有错
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int[][] ret = new Solution59().generateMatrix(n);

            String out = int2dArrayToString(ret);

            System.out.print(out);
        }
    }
}
