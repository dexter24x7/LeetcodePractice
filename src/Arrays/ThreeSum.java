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

    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (nums[i]<0){
            for (int j = nums.length; nums[j]<0; j--) {
                for (int k = j; nums[k]<0 ; k--) {
                    if (nums[i]+nums[j]+nums[k]==0)
                        res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                }
            }
            i++;
        }
        if (nums[i]+nums[i+1]+nums[i+2]==0)
            res.add(new ArrayList<>(Arrays.asList(nums[i],nums[i+1],nums[i+2])));
        return res;
    }
}
