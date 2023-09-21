package Strings;
//680. Valid Palindrome II
/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int start =0;
        int end = s.length()-1;
        return isPalindrome(s,start, end, false);
    }
    boolean isPalindrome(String s, int start, int end, boolean flag){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                if(flag) return false;
                else return isPalindrome(s,start+1,end,true) || isPalindrome(s,start,end-1,true);
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII obj = new ValidPalindromeII();
        System.out.println(obj.validPalindrome("cbbcc"));
    }
}
