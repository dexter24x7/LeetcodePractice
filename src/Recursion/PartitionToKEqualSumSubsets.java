package Recursion;
//698. Partition to K Equal Sum Subsets
/*
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 */
public class PartitionToKEqualSumSubsets {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int num: nums) sum+=num;
        int targetSum =sum/k;
        if(sum != k*targetSum) return false;
        return makePartition(nums,targetSum, new int[k], nums.length-1);
    }

    static boolean makePartition(int[] nums, int targetSum, int[] subsets,int ind){
        if(ind ==-1) return true;
        for(int i=0; i<subsets.length; i++){
            if(subsets[i]+nums[ind] <= targetSum){
                subsets[i]+=nums[ind];
                if(makePartition(nums,targetSum,subsets,ind-1)) return true;
                subsets[i]-=nums[ind];
            }
            if(subsets[i] == 0) break;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {15,3557,42,3496,5,81,34,95,9,81,42,106,71};
        int k = 11;
        System.out.println(canPartitionKSubsets(nums,k));
    }
}
