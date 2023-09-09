package BFS;

import java.util.LinkedList;
import java.util.Queue;

//994. Rotting Oranges
/*
You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
public class RottingOranges {
    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static int orangesRotting(int[][] grid) {
        Queue<Pair> rottenOranges = new LinkedList<>();
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int time = 0, freshOranges=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] ==2){
                    rottenOranges.offer(new Pair(i,j));
                    visited[i][j] = true;
                }
                if(grid[i][j] ==1){
                    freshOranges++;
                }
            }
        }
        while(!rottenOranges.isEmpty()&& freshOranges!=0){
            int rottenCount = rottenOranges.size();
            while(rottenCount-- >0){
                Pair currOrange = rottenOranges.poll();
                int r = currOrange.row;
                int c = currOrange.col;
                if(r-1 >= 0 && grid[r-1][c]==1 && !visited[r-1][c]) {
                    grid[r-1][c]=2;
                    freshOranges--;
                    rottenOranges.offer(new Pair(r-1,c));
                    visited[r-1][c] = true;
                }
                if(r+1 < grid.length && grid[r+1][c]==1 && !visited[r+1][c]){
                    grid[r+1][c]=2;
                    freshOranges--;
                    rottenOranges.offer(new Pair(r+1,c));
                    visited[r+1][c] = true;
                }
                if(c-1 >= 0 && grid[r][c-1]==1 && !visited[r][c-1]){
                    grid[r][c-1]=2;
                    freshOranges--;
                    rottenOranges.offer(new Pair(r,c-1));
                    visited[r][c-1] = true;
                }
                if(c+1 < grid[0].length && grid[r][c+1]==1 && !visited[r][c+1]){
                    grid[r][c+1]=2;
                    freshOranges--;
                    rottenOranges.offer(new Pair(r,c+1));
                    visited[r][c+1] = true;
                }
            }
            time++;
        }
        return freshOranges == 0 ?time:-1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(orangesRotting(grid));
    }
}
