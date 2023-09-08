package Stack;

import java.util.Arrays;
import java.util.Stack;

//739. Daily Temperatures
/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that
answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is
no future day for which this is possible, keep answer[i] == 0 instead.
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> tempRecord = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = n-1; i>=0; i--){
            while(!tempRecord.isEmpty() && temperatures[i] >= temperatures[tempRecord.peek()]) tempRecord.pop();
            if(!tempRecord.isEmpty()) res[i] = tempRecord.peek() -i;
            tempRecord.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
