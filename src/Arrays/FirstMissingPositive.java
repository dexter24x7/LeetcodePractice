package Arrays;
//41. First Missing Positive
/*
Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++){
            if(nums[i] >0 && nums[i]<=len ){
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums,i,nums[i]-1);
                    i--;
                }
            }
        }
        for(int i=0; i<len; i++){
            if(nums[i]-1!=i) return i+1;
        }
        return len+1;
    }

    static void swap(int[] nums, int i, int j){
        int temp= nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
