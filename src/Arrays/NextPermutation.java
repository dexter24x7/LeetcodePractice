package Arrays;

import java.util.Arrays;

//31. Next Permutation
/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible,
the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int brkPoint =-1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                brkPoint=i;
                break;
            }
        }

        if(brkPoint == -1){
            reverse(nums,0);
        }

        else{
            for(int i=nums.length-1; i>brkPoint; i--){
                if(nums[i]>nums[brkPoint]){
                    swap(nums,brkPoint,i);
                    reverse(nums,brkPoint+1);
                    break;
                }
            }
        }
    }

    static void reverse(int[] nums, int start){
        int l = start;
        int r = nums.length-1;
        while(l<r){
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }

    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,5};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
