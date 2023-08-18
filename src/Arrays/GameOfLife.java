package Arrays;

import java.util.Arrays;

//289. Game of Life
/*
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by
the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or
dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the
following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where
births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 */
public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] res = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int liveNeighbours = neighbour(board,i+1,j) + neighbour(board,i,j+1) + neighbour(board,i-1,j) + neighbour(board,i,j-1) + neighbour(board,i+1,j+1) + neighbour(board,i-1,j-1) + neighbour(board,i+1,j-1) + neighbour(board,i-1,j+1);

                if(liveNeighbours <2) res[i][j] =0;
                else if(liveNeighbours == 2 && board[i][j]==1) res[i][j] =1;
                else if(liveNeighbours == 2 && board[i][j]==0) res[i][j] =0;
                else if(liveNeighbours == 3 ) res[i][j] =1;
                else if(liveNeighbours >3 ) res[i][j] =0;
            }
        }
        for(int i=0; i<m; i++){
            System.arraycopy(res[i], 0, board[i], 0, n);
        }
    }

    public static int neighbour(int[][] board, int i, int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] ==0)
            return 0;
        return 1;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        System.out.println(Arrays.deepToString(board));

    }
}
