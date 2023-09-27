package Maths;

import java.util.Arrays;

//628. Maximum Product of Three Numbers
/*
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 */
public class MaximumProductOfThreeNumbers {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length-1;
        return Math.max(nums[0] * nums[1] * nums[len], nums[len] * nums[len - 1] * nums[len - 2]);
    }

    public static void main(String[] args) {
        int[] nums ={-3,-1,0,2,3};
        System.out.println(maximumProduct(nums));
    }
}

