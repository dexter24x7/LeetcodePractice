//169. Majority Element
/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
 */
import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,3,3,2,3};
        System.out.println(majorityElement(arr));
    }
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int res=nums[0], count=0, maxCount= 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[i-1] || i == nums.length-1){
                if (count>maxCount) {
                    maxCount = count;
                    res = nums[i - 1];
                }
                count=0;
            }
            count++;
        }

    return res;
    }
}
