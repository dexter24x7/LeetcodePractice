package DynamicProgramming;
//221. Maximal Square
/*
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */
public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i= 0; i<matrix.length; i++){
            if(matrix[i][matrix[0].length-1] =='1'){
                cache[i][matrix[0].length-1] = 1;
                max = 1;
            }
        }
        for(int i= 0; i<matrix[0].length; i++){
            if(matrix[matrix.length-1][i] =='1'){
                cache[matrix.length-1][i] = 1;
                max = 1;
            }
        }
        for(int i= matrix.length-2; i>=0; i--){
            for(int j= matrix[0].length-2; j>=0; j--){
                if(matrix[i][j]=='1'){
                    cache[i][j] = 1+Math.min(cache[i+1][j+1],Math.min(cache[i+1][j],cache[i][j+1]));
                    max= Math.max(max,cache[i][j]);
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'},};
        System.out.println(maximalSquare(matrix));
    }
}
