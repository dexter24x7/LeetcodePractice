package Maths;
//9. Palindrome Number
/*
Given an integer x, return true if x is a palindrome, and false otherwise.
 */
import java.util.Scanner;
public class NumberPalindrome {
    public static boolean isNumberPalindrome(int x){
        if (x<0) return false;
        int copy = x;
        int number = 0;
        while (copy!=0){
            number = number*10 + copy%10;
            copy/=10;
        }
        return number == x;
    }
    //Approach 2
    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        String num = Integer.toString(x);
        int l=0;
        int r=num.length()-1;
        while(l<r){
            if(num.charAt(l)!=num.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number:");
    int x= sc.nextInt();
        System.out.println(isNumberPalindrome(x));
        System.out.println(isPalindrome(x));
    }
}
