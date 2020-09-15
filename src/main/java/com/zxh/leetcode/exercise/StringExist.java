package com.zxh.leetcode.exercise;

/**
 * @Author: ningque
 * @Date: 2020/9/15
 * @Version 1.0
 */
public class StringExist {
    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     *  
     *
     * 示例:
     *
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     *
     *
     */
    boolean[][] marked;
    int[][] directions = {{-1, 0},{0, -1}, {0, 1}, {1, 0}};
    public boolean exist(char[][] board, String word) {
        // DFS + 回溯
        int n = board.length;
        int m = board[0].length;
        if (m == 0) {
            return false;
        }
        marked = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int start){
        if(start == word.length() - 1){
            return board[i][j] == word.charAt(start);
        }
        if(board[i][j] == word.charAt(start)){
            marked[i][j] = true;
            for(int k=0; k<4; k++){
                int newX = i + directions[k][0];
                int newY = j + directions[k][1];
                if(inArea(board, newX, newY) && !marked[newX][newY]){
                    if(dfs(board, word, newX, newY, start+1)){
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }
    public boolean inArea(char[][] board, int i, int j){
        int n = board.length;
        int m = board[0].length;
        return i >= 0 && n > i && m > j &&  j >= 0;
    }



    public static void main(String[] args) {
        char[][] board = {
        {'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}};
        StringExist exist = new StringExist();
        String s = new String();
        char[] ch = s.toCharArray();

        s.contains("");
        s.indexOf('c');
        System.out.println(exist.exist(board, "ABCCED"));
    }
}
