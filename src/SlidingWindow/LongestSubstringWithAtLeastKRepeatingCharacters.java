package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//395. Longest Substring with At Least K Repeating Characters
/*
Given a string s and an integer k, return the length of the longest substring of s such
that the frequency of each character in this substring is greater than or equal to k.
if no such substring exists, return 0.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static int longestSubstring(String s, int k) {
        int sLength = s.length();
        if(sLength == 0 || sLength<k) return 0;
        if(k==1) return sLength;

        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch: s.toCharArray()) freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);

        int ptr=0;
        for(int i=0; i<sLength && freqMap.get(s.charAt(i))>=k;i++){
            ptr++;
        }
        if(ptr== sLength ) return ptr;

        int firstHalf = longestSubstring(s.substring(0,ptr),k);

        while(ptr<sLength && freqMap.get(s.charAt(ptr))<k) ptr++;
        int secondHalf = longestSubstring(s.substring(ptr),k);

        return Math.max(firstHalf, secondHalf);
    }

    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        System.out.println(longestSubstring(s,k));
    }
}
