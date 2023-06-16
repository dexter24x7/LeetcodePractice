package DynamicProgramming;
//53. Maximum Sub-array
/*
Given an integer array nums, find the sub-array (A sub-array is a contiguous non-empty sequence of elements within an array.)
with the largest sum, and return its sum.
 */
public class MaximumSubArray {
    public static int maxSubArray(int[] nums) {
        int max = nums[0],currSum = nums[0];
        for(int i=1; i< nums.length; i++){
            if(currSum<0) currSum=0;
            currSum+=nums[i];
            max = Math.max(max,currSum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
    }
}
