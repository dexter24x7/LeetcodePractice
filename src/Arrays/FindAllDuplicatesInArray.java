package Arrays;

import java.util.ArrayList;
import java.util.List;

//442. Find All Duplicates in an Array
/*
Given an integer array nums of length n where all the integers of nums are in the range [1, n]
and each integer appears once or twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant extra space.
 */
public class FindAllDuplicatesInArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]<0) res.add(idx+1);
            else nums[idx] *=-1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("All the integers that appears twice are: "+findDuplicates(nums));
    }
}
