package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90. Subsets II
/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class SubsetsII {
    static boolean[] used;
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(used[i] || i>0&&(nums[i]==nums[i-1])&&!used[i-1]) continue;
            tempList.add(nums[i]);
            used[i] = true;
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums ={1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
