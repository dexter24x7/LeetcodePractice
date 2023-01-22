import java.util.Arrays;
//128. Longest Consecutive Sequence
/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
 */

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100, 200, 1, 3, 2, 4};
        System.out.println("Longest Consecutive Sequence");
        System.out.println(sequenceFinder(arr));
    }
    static int sequenceFinder(int[] nums){
        if (nums.length==0)
            return 0;
        Arrays.sort(nums);
        int res=1, count=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]+1==nums[i])
                count++;
            else if(nums[i-1]==nums[i])
                continue;
            else
                count=0;
            res = Math.max(res,count+1);
        }
        return res;    }
}