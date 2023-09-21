package Strings;
//14. Longest Common Prefix
/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        String last = strs[0];
        for(int i=1; i<strs.length; i++){
            first = first.compareTo(strs[i])<0?first:strs[i];
            last = last.compareTo(strs[i])>0?last:strs[i];
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i<Math.min(first.length(), last.length());i++){
            if(first.charAt(i) != last.charAt(i))
                return res.toString();
            res.append(first.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
