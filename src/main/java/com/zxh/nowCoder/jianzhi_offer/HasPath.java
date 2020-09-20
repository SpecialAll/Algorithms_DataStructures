package com.zxh.nowCoder.jianzhi_offer;

/**
 * @Author: ningque
 * @Date: 2020/9/17
 * @Version 1.0
 */
public class HasPath {
    /**
     * 题目描述
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
     */
    public static void main(String[] args) {
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "ABCCED".toCharArray();
        int rows = 3;
        int cols = 4;
        HasPath path  = new HasPath();
        System.out.println(path.hasPath(matrix, rows, cols, str));
    }

    boolean[] marked;
    int[][] temp = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        marked = new boolean[matrix.length];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(judge(matrix, i, j, rows, cols, str, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean judge(char[] matrix, int i, int j, int rows, int cols, char[] str, int start){
        int index = i*cols + j;
        if(start == str.length-1)
            return str[start] == matrix[index];
        if(matrix[index] == str[start]){
            marked[index] = true;
            for(int k=0; k<4; k++){
                int newX = i + temp[k][0];
                int newY = j + temp[k][1];
                index = newX * cols + newY;
                if(inArea(newX, newY, rows, cols) && !marked[index]){
                    if(judge(matrix, newX, newY, rows, cols, str, start + 1)){
                        return true;
                    }
                }
            }
            marked[i*rows + j] = false;
        }
        return false;
    }
    public boolean inArea(int i, int j, int rows, int cols){
        return i >=0 && i < rows && j >= 0 && j < cols;
    }
}
