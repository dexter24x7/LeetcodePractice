package Strings;
//3. Longest Substring Without Repeating Characters
/*
Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int l=-1, res = 0 ;
        int[] map = new int[128];
        for(int i=0; i< s.length(); i++){
            int ch = s.charAt(i);
            if(map[ch]>=l){
                l = map[ch];
            }
            res=Math.max(res,i-l+1);
            map[ch] = i+1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
