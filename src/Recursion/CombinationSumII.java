package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40. Combination Sum II
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
candidates where the candidate numbers sum to target. Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.
 */
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        getCombination(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }
     static void getCombination(int[] candidates, int target,List<Integer> combination, List<List<Integer>> res, int idx){
        if(target==0){
            res.add(new ArrayList<>(combination));
            return;
        }
        for(int i=idx; i<candidates.length; i++){
            if(i>idx && candidates[i] == candidates[i-1]) continue;
            if(candidates[i]>target) break;
            combination.add(candidates[i]);
            getCombination(candidates, target-candidates[i], combination, res, i+1);
            combination.remove(combination.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));

    }
}
