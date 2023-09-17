package Recursion;

import java.util.ArrayList;
import java.util.List;

//77. Combinations
/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.
 */
public class Combinations {
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        findCombination(new ArrayList<>(),k,n,1);
        return res;
    }

    static void findCombination(List<Integer> combination, int k, int n, int idx){
        if(k==0){
            res.add(new ArrayList<>(combination));
            return;
        }
        for(int i= idx; i<=n-k+1 ; i++){
            combination.add(i);
            findCombination(combination,k-1,n,i+1);
            combination.remove(combination.size()-1);
        }
    }

    public static void main(String[] args) {
        int n = 20, k = 20;
        System.out.println(combine(n,k));
    }
}
