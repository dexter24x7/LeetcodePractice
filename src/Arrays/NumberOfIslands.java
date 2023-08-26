package Arrays;
//200. Number of Islands
/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int count=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(dfs(grid,i,j)) count++;
            }
        }
        return count;
    }
    public static boolean dfs(char[][] grid, int i, int j ){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return false;
        }
        else if(grid[i][j]=='1'){
            grid[i][j] = '0';
            dfs(grid,i-1,j); dfs(grid,i+1,j); dfs(grid,i,j-1); dfs(grid,i,j+1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid={ {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}};
        System.out.println("Number of islands: "+numIslands(grid));
    }
}
