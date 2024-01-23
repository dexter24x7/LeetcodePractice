package Strings;
//151. Reverse Words in a String
/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words. Do not include any extra spaces.
 */
public class ReverseWordsString {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i=words.length-1; i>=0; i--){
            if(words[i].isEmpty()) continue;
            res.append(" ");
            res.append(words[i]);
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String s= "a good   example ";
        System.out.println(reverseWords(s));
    }
}
