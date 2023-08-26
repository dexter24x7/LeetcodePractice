package Arrays;

import java.util.HashSet;
import java.util.Set;

//532. K-diff Pairs in an Array
/*
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
0 <= i, j < nums.length
i != j
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.
 */
public class KdiffPairsInArray {
    public static int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> repeatSet = new HashSet<>();

        for(int n: nums){
            if(set.contains(n)) repeatSet.add(n);
            set.add(n);
        }
        if(k==0) return repeatSet.size();

        int count=0;
        for(int s: set){
            if(set.contains(s+k)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        System.out.println("The number of unique k-diff pairs in the array are:"+findPairs(nums,k));
    }
}
