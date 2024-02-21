package DFS;
//130. Surrounded Regions
/*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class SurroundedRegions {
    public static void solve(char[][] board) {
        int m= board.length;
        int n= board[0].length;
        for(int i=0; i<m; i++){
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][n-1]=='O') dfs(board,i,n-1);
        }
        for(int i=0; i<n; i++){
            if(board[0][i]=='O') dfs(board,0,i);
            if(board[m-1][i]=='O') dfs(board,m-1,i);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='Y') board[i][j]='O';
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }

    static void dfs(char[][] board, int r, int c){
        int m= board.length;
        int n= board[0].length;
        if(r<0 || r>=m || c<0 || c>=n || board[r][c]!='O') return;
        board[r][c] = 'Y';
        dfs(board,r+1,c);
        dfs(board,r-1,c);
        dfs(board,r,c+1);
        dfs(board,r,c-1);
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
    }
}
