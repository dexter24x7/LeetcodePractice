package Maths;

import java.util.Stack;

//224. Basic Calculator
/*
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 */
public class BasicCalculator {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result=0;
        int num=0;
        int sign=1;

        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10 + Character.getNumericValue(c);
            } else if(c=='+'){
                result += sign*num;
                num=0;
                sign =1;
            } else if(c=='-'){
                result += sign*num;
                num=0;
                sign = -1;
            } else if(c=='('){
                stack.push(result);
                stack.push(sign);
                result=0;
                sign=1;
            } else if(c==')'){
                result+=sign*num;
                num=0;
                result *=stack.pop();
                result+=stack.pop();
            }
        }
        result += sign*num;
        return result;
    }

    public static void main(String[] args) {
        String s = "-1-(     -2)";
        System.out.printf("The result for the expression: %s is %d",s,calculate(s));
    }
}
