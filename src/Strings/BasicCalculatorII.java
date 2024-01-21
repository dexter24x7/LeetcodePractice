package Strings;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//227. Basic Calculator II
/*
Given a string s which represents an expression, evaluate this expression and return its value.
The integer division should truncate toward zero.
You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 */
public class BasicCalculatorII {
    public static int calculate(String s) {
        if(s.isEmpty()) return 0;
        String operands = "\\d+";
        String operators = "[+-/*]";
        Matcher operandMatcher = Pattern.compile(operands).matcher(s);
        Matcher operatorMatcher = Pattern.compile(operators).matcher(s);
        Queue<Integer> operandQ = new LinkedList<>();
        Queue<String> operatorQ = new LinkedList<>();
        while(operandMatcher.find()) operandQ.offer(Integer.parseInt(operandMatcher.group()));
        while(operatorMatcher.find()) operatorQ.offer(operatorMatcher.group());
        assert !operandQ.isEmpty();
        int res = 0;
        int num=operandQ.poll();
        int prev=num;
        String op;
        res +=num;
        while(!operandQ.isEmpty()){
            op = operatorQ.poll();
            assert op != null;
            if(op.equals("*")||op.equals("/")){
                res-=prev;
            }
            num = operandQ.poll();
            switch (op) {
                case "+" -> {
                    res += num;
                    prev = num;
                }
                case "-" -> {
                    res -= num;
                    prev = -1 * num;
                }
                case "*" -> {
                    res += prev * num;
                    prev = num * prev;
                }
                case "/" -> {
                    res += prev / num;
                    prev = prev / num;
                }
                default -> System.out.println("Invalid operator");

            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        System.out.println(calculate(s));
    }
}
