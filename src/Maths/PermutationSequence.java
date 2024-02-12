package Maths;

import java.util.ArrayList;
import java.util.List;

//60. Permutation Sequence
/*
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
 */
public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        List<Integer> factorial = new ArrayList<>();
        factorial.add(1);
        for(int i=1; i<n; i++){
            factorial.add(factorial.get(i-1)*i);
        }
        k--;
        StringBuilder result = new StringBuilder();
        List<Integer> number = new ArrayList<>();
        for(int i=1;i<=n;i++){
            number.add(i);
        }
        for(int i=n-1; i>=0; i--){
            int ind = k/factorial.get(i);
            k%=factorial.get(i);
            result.append(number.get(ind));
            number.remove(ind);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        System.out.printf("The %dth permutation for n = %d is \"%s\".",k,n,getPermutation(n,k));
    }
}
