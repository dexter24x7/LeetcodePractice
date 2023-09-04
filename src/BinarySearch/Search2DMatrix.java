package BinarySearch;
//74. Search a 2D Matrix
/*
You are given an m x n integer matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.
 */
public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(matrix[mid][0]==target) return true;
            else if(matrix[mid][0]<target) start = mid+1;
            else end = mid-1;
        }
        int row = start-1;
        if(row<0) return false;
        start = 0; end = matrix[0].length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid]<target) start = mid+1;
            else end = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(searchMatrix(matrix,target));
    }
}
