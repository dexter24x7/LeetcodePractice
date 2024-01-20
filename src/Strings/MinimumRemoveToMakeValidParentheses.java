package Strings;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//1249. Minimum Remove to Make Valid Parentheses
/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 */
public class MinimumRemoveToMakeValidParentheses {
    public static String minRemoveToMakeValid(String s) {
        Set<Integer> remove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') stack.push(i);
            else if(s.charAt(i) == ')'){
                if(stack.isEmpty()) remove.add(i);
                else stack.pop();
            }
        }

        while(!stack.isEmpty()) remove.add(stack.pop());
        StringBuilder newString = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(remove.contains(i)) continue;
            newString.append(s.charAt(i));
        }
        return newString.toString();
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)"; //lee(t(c)o)de
        System.out.println(minRemoveToMakeValid(s));
    }
}
