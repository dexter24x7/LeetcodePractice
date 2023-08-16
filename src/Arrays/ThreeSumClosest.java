package Arrays;

import java.util.Arrays;

//16. 3Sum Closest
/*
Given an integer array nums of length n and an integer target,
find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if((i>0) && (nums[i]==nums[i-1])) continue;
            for (int j = i+1, k = nums.length-1; j < k; ) {
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(sum-target)<Math.abs(res-target)){
                    res=sum;
                }
                if (sum<target) j++;
                else k--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int res = threeSumClosest(nums, target);
        System.out.println("The sum of three integers in nums closest to target is "+res);
    }
}
