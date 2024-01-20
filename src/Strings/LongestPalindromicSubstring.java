package Strings;
//5. Longest Palindromic Substring
/*
Given a string s, return the longest palindromic substring
 in s.
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        String res = "";
        int resLen = -1;

        for(int i=0; i<s.length(); i++){
            //for odd length
            int left = i;
            int right =i;
            while(left>=0 && right<s.length() && s.charAt(left)== s.charAt(right)){
                if(right-left> resLen){
                    res = s.substring(left,right+1);
                    resLen = right-left;
                }
                left--;
                right++;
            }
            //for even length
            left = i;
            right =i+1;
            while(left>=0 && right<s.length() && s.charAt(left)== s.charAt(right)){
                if(right-left> resLen){
                    res = s.substring(left,right+1);
                    resLen = right-left;
                }
                left--;
                right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "babad"; //bab
        System.out.println(longestPalindrome(s));
    }
}
