package Arrays;
//287. Find the Duplicate Number
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        //considering the array as a linked list
        int fast=0;
        int slow=0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        fast = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static int findDuplicate2(int[] nums) {
        for(int i=0; i<nums.length ; i++){
            int ind = Math.abs(nums[i]);
            if(nums[ind]<0) return ind;
            nums[ind]*=-1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println("//1 Duplicate number is: "+findDuplicate(nums));
        System.out.println("//2 Duplicate number is: "+findDuplicate2(nums));
    }
}
