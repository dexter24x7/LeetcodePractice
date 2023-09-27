package Maths;
//453. Minimum Moves to Equal Array Elements
/*
Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
In one move, you can increment n - 1 elements of the array by 1.
 */
public class MinimumMovesToEqualArrayElements {
    public static int minMoves(int[] nums) {
        int min = nums[0];
        for (int num : nums) if (num < min) min = num;
        int sum=0;
        for (int num : nums) sum += num - min;
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(minMoves(nums));
    }
}
