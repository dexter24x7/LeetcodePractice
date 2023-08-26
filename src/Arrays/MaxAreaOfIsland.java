package Arrays;
//695. Max Area of Island
/*
You are given an m x n binary matrix grid. An island is a group of 1's
(representing land) connected 4-directionally (horizontal or vertical.)
You may assume all four edges of the grid are surrounded by water.
The area of an island is the number of cells with a value 1 on the island.
Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        // //remove non islands
        // for(int i=0; i<grid[0].length;i++){
        //     dfs(grid,0,i);
        //     dfs(grid,grid.length-1,i);
        // }
        // for(int i=0; i<grid.length;i++){
        //     dfs(grid,i,0);
        //     dfs(grid, i,grid[0].length-1);
        // }
        //get the largest island
        int largest =0;
        for(int i=0;i<grid.length; i++){
            for(int j=0;j<grid[0].length; j++){
                largest = Math.max(largest,dfs(grid,i,j));
            }
        }
        return largest;
    }
    //function to get island size
    public static int dfs(int[][] grid,int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
            return 0;
        else if(grid[i][j] ==1){
            grid[i][j]=0;
            return 1+dfs(grid,i+1,j)+dfs(grid,i-1,j)+dfs(grid,i,j+1)+dfs(grid,i,j)+dfs(grid,i,j-1);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
