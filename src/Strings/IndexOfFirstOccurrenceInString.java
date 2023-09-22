package Strings;
//28. Find the Index of the First Occurrence in a String
/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class IndexOfFirstOccurrenceInString {
    public static int strStr(String haystack, String needle) {
        for(int i=0; i<haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)&&matcher(haystack,needle,i)) return i;
        }
        return -1;
    }
    static boolean matcher(String haystack, String needle, int start){
        int ind =0;
        while(start<haystack.length()&& ind<needle.length()){
            if(haystack.charAt(start++) != needle.charAt(ind++)) return false;
        }
        return ind >= needle.length();
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr(haystack,needle));
    }
}
