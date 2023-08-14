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
        int left = 0;
        int right = matrix.length-1;
        while(left<right){
            for(int i=0; i<(right-left); i++){
                int top=left;
                int bottom = right;

                int topLeft = matrix[top][left+i];
                matrix[top][left+i] = matrix[bottom-i][left];
                matrix[bottom-i][left] = matrix[bottom][right-i];
                matrix[bottom][right-i] = matrix[top+i][right];
                matrix[top+i][right] = topLeft;
            }
            right-=1;
            left+=1;
        }
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
