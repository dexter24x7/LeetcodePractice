package Maths;
//233. Number of Digit One
/*
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 */
public class NumberOfDigitOne {
    public static int countDigitOne(int n) {
        int count = 0;
        int i = 1;

        while (i <= n) {
            int divisor = i * 10;
            count += (n / divisor) * i + Math.min(Math.max(n % divisor - i + 1, 0), i);
            i *= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        int n=1000000000;
        System.out.printf("The total number of digit 1 appearing in all non-negative integers less than or equal to %d are %d",n,countDigitOne(n));
    }
}
