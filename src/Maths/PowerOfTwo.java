package Maths;
//231. Power of Two
/*
Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2^x.
 */
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        return n>0 && (n & n-1) ==0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }
}
