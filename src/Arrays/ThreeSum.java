package Arrays;
import java.util.*;
//15. 3Sum
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
 */

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum1(nums));
        System.out.println(threeSum(nums));

    }
    //Brute force approach
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); //sorting to keep -ve and +ve separate
        int i = 0;
        int prev=0;
        while (i<nums.length && nums[i]<0){ //loop 1 runs for negative numbers
            if (nums[i]==prev) {// to avoid repeated pairs
                i++;
                continue;}
            //part 1 - [-ve,+ve,+ve]
            for (int j = nums.length-1; nums[j]>=0; j--) { //loop 2 for non-negative
                if (j< nums.length-1 && nums[j]==nums[j+1]) continue;
                for (int k = j-1; nums[k]>=0 ; k--) { //loop 3 for non-negative
                    if (k<j && nums[k]==nums[k-1]) continue;
                    if (nums[i]+nums[j]+nums[k]==0)
                        res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                }
            }
            //part 2 - [-ve,-ve,+ve]
            for (int j = i+1;j<nums.length && nums[j]<0; j++) {//loop 2 for negative
                if (j>i+1 && nums[j]==nums[j-1]) continue;
                for (int k = nums.length-1; nums[k]>=0 ; k--) {//loop 3 for non-negative
                    if (k<nums.length-1 && nums[k]==nums[k+1]) continue;
                    if (nums[i]+nums[j]+nums[k]==0)
                        res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                }
            }
            prev = nums[i];
            i++;
        }
        if (i+2<nums.length && nums[i]+nums[i+1]+nums[i+2]==0) //check for the case of [0,0,0]
            res.add(new ArrayList<>(Arrays.asList(nums[i],nums[i+1],nums[i+2])));
        return res;
    }

    //two pointer approach with HashSet
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = nums.length-1;
            for (int j = i+1; j < k; ) {
                int sum = nums[i]+nums[j]+nums[k];
                if (sum==0)
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[j++],nums[k--])));
                if (sum<0) j++;
                if (sum>0) k--;
            }
        }
        return new ArrayList<>(ans);
    }

}
