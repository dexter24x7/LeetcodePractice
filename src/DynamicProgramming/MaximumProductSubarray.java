package DynamicProgramming;
//152. Maximum Product Subarray
/*
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.
 */
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0], max =nums[0], min=nums[0];
        for(int i=1; i<nums.length; i++){
            int temp = max;
            max = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            min = Math.min(Math.min(temp*nums[i],min*nums[i]),nums[i]);
            maxProduct = Math.max(max,maxProduct);
        }
        return maxProduct;
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

}
