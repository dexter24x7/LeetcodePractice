package Arrays;

import java.util.HashSet;
import java.util.Set;

//217. Contains Duplicate
/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for(int num: nums){
            if(visited.contains(num)) return true;
            visited.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,1};
        System.out.println(containsDuplicate(nums));
    }
}
