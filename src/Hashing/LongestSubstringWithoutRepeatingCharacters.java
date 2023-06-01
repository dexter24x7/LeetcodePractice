package Hashing;
//3. Longest Substring Without Repeating Characters
/*
Given a string s, find the length of the longest substring without repeating characters.
 */
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int l = -1, res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > l) {
                l = map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), i);
                res = Math.max(res, i - l);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.print("The length of the longest substring without repeating characters is:");
        System.out.println(lengthOfLongestSubstring(s));
    }
}
