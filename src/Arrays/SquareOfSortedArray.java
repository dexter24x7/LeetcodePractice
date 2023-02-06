package Arrays;

//977. Squares of a Sorted Array
/*
Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquareOfSortedArray {
    public static void main(String[] args) {
    int[] nums ={0};
    nums = sortedSquares(nums);
        for (int n : nums) {
            System.out.println(n);
        }
    }
    public static int[] sortedSquares(int[] nums) {
        int size = nums.length;
        int[] res =new int[size];
        for (int i = 0; i < size; i++)
            nums[i]*=nums[i];
        int left=0, right = size-1;
        for (int i = size-1; i >= 0; i--) {
           if (nums[left]>nums[right])
               res[i]=nums[left++];
           else res[i]=nums[right--];
        }
        return res;
    }
}
