package Miscellaneous;

import java.util.Scanner;
import java.util.Stack;
public class ValidParentheses {

    public static boolean isValid(String s){
        /*Define counter for each bracket type
            loop for string length{
            counter++ for an open bracket
            counter-- for a closed bracket
            abort if the counter is negative
            }
            false if the counter is !=0 at end
        */
        Stack<Character> stk = new Stack<>();

        for (int i=0; i<s.length(); i++){
            switch (s.charAt(i)){
                case '('-> stk.push(')');
                case '['-> stk.push(']');
                case '{'-> stk.push('}');
                default -> {
                    if (stk.isEmpty()||(stk.pop()!= s.charAt(i)))
                        return false;
                }
            }

        }
        return stk.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  s = sc.nextLine();
        System.out.println(isValid(s));
    }
}
