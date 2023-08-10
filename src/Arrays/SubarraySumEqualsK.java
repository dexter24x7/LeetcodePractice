package Arrays;

import java.util.HashMap;
import java.util.Map;

//560. Subarray Sum Equals K
/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        System.out.println("Total number of sub-arrays whose sum equals to "+k+" is: "+subarraySum(nums,k));
    }
}
