package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//78. Subsets
/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets {
    //Backtracking
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    //Using Binary Strings
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < (1 << len); i++) {
            res.add(new ArrayList<>());
            String binary = Integer.toBinaryString(i);
            int bl = binary.length();
            for(int j = 0 ; j< bl; j++){
                if(binary.charAt(j)=='1') res.get(i).add(nums[len -bl +j]);
            }
            System.out.println(binary);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
        System.out.println(subsets2(nums));
    }
}
