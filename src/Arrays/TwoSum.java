package Arrays;

import java.util.Arrays;
import java.util.HashMap;

//1. Two Sum
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0],0);
        for(int i=1; i<nums.length; i++){
            int required = target-nums[i];
            if(map.containsKey(required)){
                return new int[]{map.get(required),i};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}
