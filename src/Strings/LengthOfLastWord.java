package Strings;
//58. Length of Last Word
/*
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        s=s.trim();
        int count=0;
        for (int i=s.length()-1; i>=0; i--){
            if (s.charAt(i)==' ')  break;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "   fly me to the moon   ";
        System.out.println(lengthOfLastWord(s));
    }
}
