package Strings;
//415. Add Strings
/*
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
You must also not convert the inputs to integers directly.
 */
public class AddStrings {
    public static String addStrings(String num1, String num2) {
        StringBuilder sb  = new StringBuilder();
        int l1 = num1.length()-1;
        int l2 = num2.length()-1;
        int rem=0;

        while(l1>=0 || l2>=0){
            int digit = rem;
            if(l1>=0) digit += num1.charAt(l1--)-'0';
            if(l2>=0) digit += num2.charAt(l2--)-'0';

            sb.append(digit%10);
            rem = digit/10;
        }
        if(rem!=0) sb.append(rem);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "11416932";
        String num2 = "4562879";
        String sum = addStrings(num1, num2);
        System.out.println("Sum of "+num1+" & "+num2+" is "+sum);
    }
}
