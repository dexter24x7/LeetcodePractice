package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//47. Permutations II
/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */
public class PermutationsII {
    static boolean[] used;
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        findPermutation(nums,new ArrayList<>());
        return res;
    }

    static void findPermutation(int[] nums, List<Integer> permutation){
        //when the permutation is complete
        if(permutation.size() == nums.length){
            res.add(new ArrayList<>(permutation));
            return;
        }
        int prev=-11;
        for(int i=0; i< nums.length; i++){
            if(prev != -11 && nums[i] == prev) continue;
            //we cannot reuse an element in a single permutation
            if(used[i]) continue;
            //add current element to permutation
            permutation.add(nums[i]);
            used[i] =true;
            //recursive call
            findPermutation(nums,permutation);
            //backtrack
            permutation.remove(permutation.size()-1);
            used[i] = false;
            prev = nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        System.out.println(permuteUnique(nums));
    }
}
