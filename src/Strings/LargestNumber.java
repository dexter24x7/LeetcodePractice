package Strings;

import java.util.Arrays;

//179. Largest Number
/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
Since the result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, (num1, num2) -> (num2+num1).compareTo(num1+num2));
        if(strArr[0].equals("0")) return "0";
        StringBuilder res = new StringBuilder();
        for(String str: strArr) res.append(str);
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
