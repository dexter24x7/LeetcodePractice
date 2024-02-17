package DFS;

import java.util.Stack;

//394. Decode String
/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.
 */
public class DecodeString {
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stk = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch==']'){
                StringBuilder str = new StringBuilder();
                StringBuilder insertionStr = new StringBuilder();
                StringBuilder num = new StringBuilder();
                while(!stk.peek().equals("[")){
                    str.insert(0,stk.pop());
                }
                stk.pop();
                while(!stk.isEmpty() && Character.isDigit(stk.peek().charAt(0))){
                    num.insert(0,stk.pop());
                }
                int multiplier = Integer.parseInt(num.toString());
                while(multiplier-->0) insertionStr.append(str);
                stk.push(insertionStr.toString());
            }
            else{
                stk.push(Character.toString(ch));
            }
        }
        while(!stk.isEmpty()){
            sb.insert(0,stk.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "25[abc]3[cd]ef";
        System.out.printf("The given Encoded String:%s the decoded string is: %s",s,decodeString(s));
    }
}
