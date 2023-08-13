package Arrays;

import java.util.Arrays;

//48. Rotate Image
/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {
    //Approach 1: Swapping corners
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int dx = 0;
        while(n>1){
            int top = dx/2;
            int bottom = dx/2 + n -1;
            int left = dx/2;
            int right = dx/2 + n -1;

            for(int i=0; i<n-1;i++){
                swap(matrix, new int[]{top,left+i}, new int[]{top+i,right}, new int[]{bottom,right-i}, new int[]{bottom-i,left});
            }
            dx += 2;
            n = matrix.length - dx;
        }
    }
    public static void swap(int[][] matrix, int[] first, int[] second, int[] third, int[] fourth){
        int temp = matrix[first[0]][first[1]];
        matrix[first[0]][first[1]] =  matrix[fourth[0]][fourth[1]];
        matrix[fourth[0]][fourth[1]] = matrix[third[0]][third[1]];
        matrix[third[0]][third[1]] = matrix[second[0]][second[1]];
        matrix[second[0]][second[1]] = temp;
    }

    //Approach 2: Transpose and flip columns
    public static void rotate2(int[][] matrix) {
        //FLip columns
        for(int i=0; i<matrix.length; i++){
            int l = 0;
            int r = matrix.length-1;
            while(l<=r){
                int temp = matrix[l][i];
                matrix[l][i] = matrix[r][i];
                matrix[r][i] = temp;
                l++;
                r--;
            }
        }

        //transpose
        for(int i=0; i<matrix.length; i++){
            for(int j=i+1; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(image);
        System.out.println(Arrays.deepToString(image));
        rotate2(image);
        System.out.println(Arrays.deepToString(image));
    }
}
