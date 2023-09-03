package BinarySearch;
//1351. Count Negative Numbers in a Sorted Matrix
/*
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 */
public class CountNegativeNumbersInSortedMatrix {
    public static int countNegatives(int[][] grid) {

        int start=0, end = grid.length-1;
        //count the completely negative rows
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(grid[mid][0] < 0) end = mid-1;
            else start = mid+1;
        }
        int posRows = start;
        int negCount = grid[0].length*(grid.length-posRows);

        //count number of negative numbers in partially negative rows
        for(int i=0; i<posRows; i++){
            start=0;
            end = grid[i].length-1;
            while(start<=end) {
                int mid = start + (end-start)/2;
                if(grid[i][mid] >=0) start = mid+1;
                else end = mid-1;
            }
            negCount += grid[0].length-start;
        }
        return negCount;
    }

    public static void main(String[] args) {
        int[][] grid ={{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }
}
