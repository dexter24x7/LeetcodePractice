package DynamicProgramming;
import java.util.Arrays;
import java.util.List;

//139. Word Break
/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into
a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int l = s.length();
        boolean[] dp = new boolean[l+1];
        dp[l] = true;

        for(int i = l-1; i>=0; i--){
            for(String word: wordDict){
                if(word.length()+i<=l && wordMatch(word,i,s))
                    dp[i] = dp[i+word.length()];
                if(dp[i]) break;
            }
        }
        return dp[0];
    }
    static boolean wordMatch(String word, int i, String s){
        for(int j=0; j<word.length(); j++){
            if(s.charAt(i+j) != word.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDictArr = {"leet", "code"};
        System.out.println(wordBreak(s, Arrays.asList(wordDictArr)));
    }
}
