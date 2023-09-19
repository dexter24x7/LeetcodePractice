package Recursion;

import java.util.ArrayList;
import java.util.List;

//17. Letter Combinations of a Phone Number
/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class LetterCombinationsOfPhoneNumber {
    static final char[][] keyMap = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    static List<String> res;
    public static List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.isEmpty()) return res;
        letterCombination(digits, new StringBuilder() ,0);
        return res;
    }

    static void letterCombination(String digits, StringBuilder combination, int ind){
        if(ind == digits.length()){
            res.add(combination.toString());
            return;
        }
        int digit = digits.charAt(ind)-'0';
        for(char letter : keyMap[digit]){
            combination.append(letter);
            letterCombination(digits, combination,ind+1);
            combination.setLength(combination.length()-1);
        }
    }

    public static void main(String[] args) {
        String digits = "4586";
        System.out.println(letterCombinations(digits));
    }
}
