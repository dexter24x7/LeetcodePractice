package Maths;
//8. String to Integer (atoi)
/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */
public class StringToInteger {
    public static int myAtoi(String s) {
        s= s.trim();
        if(s.isEmpty()) return 0;
        int sign =1;
        int start=0;
        int res=0;
        if(s.charAt(0)=='-' || s.charAt(0)=='+' ){
            start++;
            sign=s.charAt(0)=='-'?-1:1;
        }
        while(start<s.length() && Character.isDigit(s.charAt(start))){
            int digit =  s.charAt(start++)-'0';
            if (res * sign > (Integer.MAX_VALUE-digit)/10) {
                return Integer.MAX_VALUE;
            }
            if (res * sign < (Integer.MIN_VALUE+digit)/10) {
                return Integer.MIN_VALUE;
            }
            res = res*10 + digit;
        }
        return res*sign;
    }

    public static void main(String[] args) {
        String s = "   -42";
        System.out.println(myAtoi(s));
    }
}
