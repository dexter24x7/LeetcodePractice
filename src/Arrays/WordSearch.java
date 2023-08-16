package Arrays;
//79. Word Search
/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
public class WordSearch {
    static boolean[][] visited;
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i<m;i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, i, j, 0, word)) return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, int i, int j,int index, String word){
        if(index == word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || word.charAt(index)!=board[i][j] || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        boolean res = (dfs(board, i+1, j, index+1, word)) || (dfs(board, i, j+1, index+1, word)) || (dfs(board, i-1, j, index+1, word)) ||(dfs(board, i, j-1, index+1, word));
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','D'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist( board,  word));
    }
}
