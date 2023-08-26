package Arrays;
//448. Find All Numbers Disappeared in an Array
/*
Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.
 */
import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for(int n: nums){
            int i = Math.abs(n)-1;
            if(nums[i]>0)
                nums[i] *=-1;
        }
        List<Integer> res= new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0) res.add(i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));

    }
}
