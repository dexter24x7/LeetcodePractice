package Heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//767. Reorganize String
/*

Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
Return any possible rearrangement of s or return "" if not possible.
 */
public class ReorganizeString {
    public static String reorganizeString(String s) {
        int sLength = s.length();

        //adding count of the letters in a hashmap
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < sLength; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        //insert the letters and their count in a max heap
        PriorityQueue<Map.Entry<Character,Integer>> charCount = new PriorityQueue<>((x, y)->(y.getValue()-x.getValue()));
        charCount.addAll(map.entrySet());
        int maxCharCount = charCount.peek().getValue();
        if(maxCharCount>(sLength-maxCharCount)+1) return"";

        StringBuilder[] strArr = new StringBuilder[maxCharCount];
        int pos = 0;
        while(!charCount.isEmpty()){
            Map.Entry<Character,Integer> currChar = charCount.poll();
            for(int i=0; i<currChar.getValue(); i++){
                if(strArr[i]==null) strArr[i] = new StringBuilder();
                strArr[(pos++)%maxCharCount].append(currChar.getKey());
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i<maxCharCount;i++)
            res.append(strArr[i].toString());
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "aaaaabcd";
        System.out.println(reorganizeString(s));
    }
}
