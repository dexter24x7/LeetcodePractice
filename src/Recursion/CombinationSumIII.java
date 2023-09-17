package Recursion;

import java.util.ArrayList;
import java.util.List;

//216. Combination Sum III
/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
    Only numbers 1 through 9 are used.
    Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice,
and the combinations may be returned in any order.
 */
public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        getCombination(k,n, new ArrayList<>(), res, 1);
        return res;
    }
    static void getCombination(int k, int n,List<Integer> combination, List<List<Integer>> res, int ind){
        if(n==0 && k==0){
            res.add(new ArrayList<>(combination));
            return;
        }
        else if(k==0) return;
        for(int i=ind; i<10; i++){
            if(i>n) break;
            combination.add(i);
            getCombination(k-1, n-i, combination, res, i+1);
            combination.remove(combination.size()-1);
        }
    }

    public static void main(String[] args) {
        int k=2;
        int n=60;
        System.out.println(combinationSum3(k,n));
    }
}
