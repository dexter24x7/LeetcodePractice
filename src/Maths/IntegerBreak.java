package Maths;
//343. Integer Break
/*
Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
Return the maximum product you can get.
 */
public class IntegerBreak {
    public static int integerBreak(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        for(int i=1; i<n; i++){
            arr[i] = i;
            helper(i,arr);
        }
        helper(n,arr);
        return arr[n];
    }

    public static void helper(int n, int[] arr){
        for(int i=1; i<n; i++){
            arr[n] = Math.max(arr[n], arr[i]*arr[n-i]);
        }
    }

    public static void main(String[] args) {
        int n=58;
        System.out.println(integerBreak(n));
    }
}
