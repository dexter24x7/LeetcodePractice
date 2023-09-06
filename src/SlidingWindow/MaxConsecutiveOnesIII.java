package SlidingWindow;
//1004. Max Consecutive Ones III
/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 */
public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int zeroes = 0;
        int left=0, right=0;
        while(right<nums.length){
            if(nums[right]==0) zeroes++;
            right++;
            if(zeroes>k){
                if(nums[left]==0) zeroes--;
                left++;
            }
        }
        return right-left;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k =2;
        System.out.println(longestOnes(nums,k));
    }
}
