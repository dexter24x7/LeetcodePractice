package Arrays;

import java.util.ArrayList;
import java.util.List;

//39. Combination Sum
/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique
combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150
combinations for the given input.
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(res, candidates, 0, cur, target);
        return res;
    }
    public static void dfs(List<List<Integer>> res, int[] candidates, int i, List<Integer> cur, int total){
        if(total == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(i>=candidates.length || total<0) return;
        cur.add(candidates[i]);
        dfs(res, candidates,i,cur, total-candidates[i]);
        cur.remove(cur.size()-1);
        dfs(res, candidates,i+1,cur, total);
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println("List of all unique combinations of candidates where the chosen numbers sum to target are: "+combinationSum(candidates,target));
    }
}
