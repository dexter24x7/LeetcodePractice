package Arrays;

import java.util.ArrayList;
import java.util.List;

//54. Spiral Matrix
/*
Given an m x n matrix, return all elements of the matrix in spiral order.
 */
@SuppressWarnings("ALL")
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;

        while(left<=right && top<=bottom){
            for(int i = left; i<=right; i++){
                ans.add(matrix[top][i]);
                System.out.println("a");
            }
            top++;

            for(int i = top; i<=bottom; i++){
                ans.add(matrix[i][right]);
                System.out.println("b");
            }
            right--;

            if(top<=bottom){
                for(int i = right; i>=left; i--){
                    ans.add(matrix[bottom][i]);
                    System.out.println("c");
                }
                bottom--;
            }

            if(left<=right){
                for(int i = bottom; i>=top; i--){
                    ans.add(matrix[i][left]);
                    System.out.println("d");
                }
                left++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
