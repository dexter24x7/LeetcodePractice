package BinarySearch;

import java.util.Arrays;

//34. Find First and Last Position of Element in Sorted Array
/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res,-1);
        int start =0, end = nums.length-1;
        while(start<=end){
            int mid= start + (end-start)/2;
            if(nums[mid] == target) res[0] = mid;
            if(nums[mid] >= target) end = mid-1;
            else start = mid+1;
        }
        start =0; end = nums.length-1;
        while(start<=end){
            int mid= start + (end-start)/2;
            if(nums[mid] == target) res[1] = mid;
            if(nums[mid] <= target) start = mid+1;
            else end = mid-1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
