package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//949. Largest Time for Given Digits
/*
Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.
24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.
Return the latest 24-hour time in "HH:MM" format. If no valid time can be made, return an empty string.
 */
public class LargestTimeForGivenDigits {
    boolean[] used;
    String latestTime;
    public String largestTimeFromDigits(int[] arr) {
        latestTime="";
        Arrays.sort(arr);
        used = new boolean[4];
        findPermutation(arr,new ArrayList<>());
        return latestTime;
    }
    void findPermutation(int[] nums, List<Integer> permutation){
        //when the permutation is complete we check for valid time
        //if the time is valid we add to the result/
        //as our arr is sorted the last permutation is the latest time
        if(permutation.size() == nums.length){
            int hrs = permutation.get(0)*10+permutation.get(1);
            int min = permutation.get(2)*10+permutation.get(3);
            if(hrs>23 || min >59) return;
            latestTime = String.format("%02d:%02d", hrs, min);
            return;
        }
        int prev=-1;
        for(int i=0; i< nums.length; i++){
            if(prev != -1 && nums[i] == prev) continue;
            //we cannot reuse an element in a single permutation
            if(used[i]) continue;
            //add current element to permutation
            permutation.add(nums[i]);
            used[i] =true;
            //recursive call
            findPermutation(nums,permutation);
            //backtrack
            permutation.remove(permutation.size()-1);
            used[i] = false;
            prev = nums[i];
        }
    }

    public static void main(String[] args) {
        LargestTimeForGivenDigits obj = new LargestTimeForGivenDigits();
        int[] arr = {2,9,9,5};
        System.out.println(obj.largestTimeFromDigits(arr));
    }
}
