package Arrays;

import java.util.Arrays;

//238. Product of Array Except Self
/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product
of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductOfArrayExceptSelf {
    //Approach 1
    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int prefixProduct = 1;
        int suffixProduct = 1;
        int posProduct=nums[0];
        int flag=0;

        for(int i=1; i<nums.length; i++){
            suffixProduct*=nums[i];
            if(nums[i]!=0) posProduct*=nums[i];
            else flag++;
        }

        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==0 && flag==1){
                answer[i] = posProduct;
            }
            else{
                answer[i] = prefixProduct*suffixProduct;
            }
            prefixProduct *= nums[i];
            if(nums[i+1]==0) continue;
            suffixProduct /= nums[i+1];
        }
        answer[nums.length-1] = prefixProduct;

        return answer;
    }

    //Approach 2
    public static int[] productExceptSelf2(int[] nums) {
        int[] answer = new int[nums.length];
        //prefix
        answer[0] = 1;
        for(int i=1; i<nums.length; i++){
            answer[i] = answer[i-1]*nums[i-1];
        }
        //suffix
        int suffix = 1;
        for(int i=nums.length-1;i>=0; i--){
            answer[i] *= suffix;
            suffix*=nums[i];
        }
        return answer;
    }
    public static void main(String[] args) {
       int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
    }
}
