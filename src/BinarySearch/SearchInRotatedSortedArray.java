package BinarySearch;
//33. Search in Rotated Sorted Array
/*
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
or -1 if it is not in nums. You must write an algorithm with O(log n) runtime complexity.
 */

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n-1, k=0;
        //if nums is rotated find the pivot
        if(nums[start]>nums[end]){
            //binary search to find the start of array
            while(start<=end){
                int mid = start + (end-start)/2;
                if(nums[mid]<=nums[n-1]) end = mid-1;
                else start = mid+1;
            }
            k=start;
        }

        //set the pointers for binary search of target
        start = 0;
        end = n-1;
        //if target > last ele then target in first half
        if(nums[n-1]<target) end = (n+k-1)%n;
        else start = k;

        //binary search to find target
        while(start<=end){
            int mid = start+ (end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target =0;
        System.out.println(search(nums,target));
    }
}
