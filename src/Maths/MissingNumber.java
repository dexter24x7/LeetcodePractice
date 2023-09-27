package Maths;
//268. Missing Number
/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n=nums.length;
        n=n*(n+1)/2;
        for(int num: nums) n-=num;
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }
}
