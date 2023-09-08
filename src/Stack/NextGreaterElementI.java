package Stack;

import java.util.Arrays;

//496. Next Greater Element I
/*
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j]
in nums2. If there is no next greater element, then the answer for this query is -1.
Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 */
public class NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nxtGreater = new int[nums1.length];
        int idx=0;
        for(int num1 : nums1){
            boolean flag = false;
            nxtGreater[idx] = -1;
            for(int num2 : nums2){
                if(num1 == num2) flag=true;
                if(flag && num2>num1){
                    nxtGreater[idx] = num2;
                    break;
                }
            }
            idx++;
        }
        return nxtGreater;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
    }
}
