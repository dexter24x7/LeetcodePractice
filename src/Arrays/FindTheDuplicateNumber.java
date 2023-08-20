package Arrays;

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

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println("Duplicate number is: "+findDuplicate(nums));
    }
}
