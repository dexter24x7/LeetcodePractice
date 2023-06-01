package Miscellaneous;

import java.util.Scanner;
//to be completed
/*
60. Permutation Sequence
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
Given n and k, return the kth permutation sequence.
 */
public class PermutationSequence {
    static String getPermutation(int n, int k) {
        if (n==0)
            return "";
        int digit= (int)Math.ceil((double)k / factorial(n - 1));
        return digit + getPermutation(n - 1, (int) (k % factorial(n - 1)));
    }
    static double factorial(int n){
        if (n<=0)
            return 1;
        return n*factorial(n-1);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("n=");
        int n = sc.nextInt();
        System.out.print("k=");
        int k = sc.nextInt();
        System.out.println(getPermutation(n,k));
    }
}
