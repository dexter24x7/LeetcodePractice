package Recursion;

import java.util.ArrayList;
import java.util.List;

//46. Permutations
/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findPermutation(nums,res,new ArrayList<>());
        return res;
    }

    static void findPermutation(int[] nums, List<List<Integer>> res, List<Integer> permutation){
        //when the permutation is complete
        if(permutation.size() == nums.length){
            res.add(new ArrayList<>(permutation));
            return;
        }
        for(int num: nums){
            //we cannot reuse an element in a single permutation
            if(permutation.contains(num)) continue;
            //add current element to permutation
            permutation.add(num);
            //recursive call
            findPermutation(nums,res,permutation);
            //backtrack
            permutation.remove(permutation.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
