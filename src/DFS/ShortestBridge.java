package DFS;

import java.util.LinkedList;
import java.util.Queue;

//934. Shortest Bridge
/*
You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
You may change 0's to 1's to connect the two islands to form one island.
Return the smallest number of 0's you must flip to connect the two islands.
 */
public class ShortestBridge {
    static Queue<Integer[]> queue = new LinkedList<>();
    public static int shortestBridge(int[][] grid) {
        int n = grid.length;
        int steps=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    dfs(grid, i,j);
                    i=n;
                    break;
                }
            }
        }

        while(!queue.isEmpty()){
            int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
            int size= queue.size();
            for(int i=0; i<size; i++){
                Integer[] curr = queue.poll();
                for(int[] dir: directions ){
                    assert curr != null;
                    int row = curr[0]+dir[0];
                    int col = curr[1]+dir[1];
                    if(row<0 || row>=n || col<0 || col>=n || grid[row][col]==2) continue;
                    if(grid[row][col]==1) return steps;
                    grid[row][col]=2;
                    queue.offer(new Integer[]{row, col});
                }
            }
            steps++;
        }
        return steps;
    }

    static void dfs(int[][] grid, int r, int c){
        int n = grid.length;
        if(r<0 || r>=n || c<0 || c>=n || grid[r][c]!=1) return;
        grid[r][c] =2;
        queue.offer(new Integer[]{r,c});
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        System.out.printf("The smallest number of 0's you must flip to connect the two islands is %d",shortestBridge(grid));
    }
}
