package Recursion;

import java.util.Arrays;

//733. Flood Fill
/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color
as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color
of all the aforementioned pixels with color. Return the modified image after performing the flood fill.
 */
public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] != color) dfs(image,sr,sc,image[sr][sc],color);
        return image;
    }

     static void dfs(int[][] image, int r, int c,int ownColor, int color){
        if(r<0||c<0||r>=image.length||c>=image[0].length|| image[r][c]!=ownColor) return;
        image[r][c] = color;
        dfs(image, r-1, c, ownColor, color);
        dfs(image, r, c-1, ownColor, color);
        dfs(image, r+1, c, ownColor, color);
        dfs(image, r, c+1, ownColor, color);
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        System.out.println(Arrays.deepToString(floodFill(image,sr,sc,color)));
    }

}
