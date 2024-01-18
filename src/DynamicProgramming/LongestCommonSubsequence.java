package DynamicProgramming;

//1143. Longest Common Subsequence
/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing
the relative order of the remaining characters. For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] lcs = new int[text1.length()+1][text2.length()+1];
        for(int i=1; i<=text1.length(); i++){
            for(int j=1; j<=text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    lcs[i][j] = 1+ lcs[i-1][j-1];
                }
                else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }

            }
        }
        return lcs[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1,text2));
    }
}
