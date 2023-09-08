package Stack;

import java.util.Stack;

//844. Backspace String Compare
/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
Note that after backspacing an empty text, the text will continue empty.
 */
public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for(char ch: s.toCharArray()){
            if(stackS.isEmpty()&& ch == '#') continue;
            if(!stackS.isEmpty()&& ch == '#') stackS.pop();
            else stackS.push(ch);
        }
        for(char ch: t.toCharArray()){
            if(stackT.isEmpty()&& ch == '#') continue;
            if(!stackT.isEmpty()&& ch == '#') stackT.pop();
            else stackT.push(ch);
        }
        while(!stackS.isEmpty()&&!stackT.isEmpty()){
            if(stackS.pop() != stackT.pop()) return false;
        }
        return stackS.isEmpty()&&stackT.isEmpty();
    }

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompare(s,t));
    }
}
