package Arrays;

import java.util.HashMap;
import java.util.Map;

//974. Subarray Sums Divisible by K
/*
Given an integer array nums and an integer k, return the number of non-empty sub-arrays that have a sum divisible by k.
A sub-array is a contiguous part of an array.
 */
public class SubarraySumsDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put((nums[0]%k+k)%k,1);
        int len = nums.length;
        int count=0;
        //forward sum
        for(int i=1; i<len; i++){
            nums[i] += nums[i-1];
            map.put((nums[i]%k+k)%k, map.getOrDefault((nums[i]%k+k)%k,0)+1);
        }
        for(int i :map.keySet()){
            int val = map.get(i);
            if(val>=1) count += (val*(val-1)/2);
            if(i==0) count+=val;

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(nums,k));
    }
}
