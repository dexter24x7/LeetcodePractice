package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//47. Permutations II
/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */
public class PermutationsII {
    static HashMap<Integer,Integer> map = new HashMap<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        for(int num: nums) map.put(num,map.getOrDefault(num,0)+1);
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
        for(int num: nums){
            if(prev != -11 && num == prev) continue;
            //we cannot reuse an element in a single permutation
            if(map.get(num)==0) continue;
            //add current element to permutation
            permutation.add(num);
            map.put(num,map.get(num)-1);
            //recursive call
            findPermutation(nums,permutation);
            //backtrack
            permutation.remove(permutation.size()-1);
            map.put(num,map.get(num)+1);
            prev = num;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        System.out.println(permuteUnique(nums));
    }
}
