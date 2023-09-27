package Maths;

import java.util.HashSet;

//202. Happy Number
/*
Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n != 0) {
                int rem = n % 10;
                sum += rem * rem;
                n /= 10;
            }
            if (sum == 1) return true;
            n = sum;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(56));
    }
}
