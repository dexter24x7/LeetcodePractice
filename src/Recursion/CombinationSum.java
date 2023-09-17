package Recursion;

import java.util.ArrayList;
import java.util.List;

//39. Combination Sum
/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of
candidates where the chosen numbers sum to target. You may return the combinations in any order. The same number may be
chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the
chosen numbers is different.The test cases are generated such that the number of unique combinations  that sum up to
target is less than 150 combinations for the given input.
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        getCombination(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }

    static void getCombination(int[] candidates, int target,List<Integer> combination, List<List<Integer>> res, int idx){
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList<>(combination));
            return;
        }
        for(int i=idx; i<candidates.length; i++){
            combination.add(candidates[i]);
            getCombination(candidates, target-candidates[i], combination, res, i);
            combination.remove(combination.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}
