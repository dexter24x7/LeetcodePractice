package Arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
    int[] nums1= {1,2,3,0,0,0};
    int[] nums2= {2,5,6};
    int m=nums1.length-nums2.length, n= nums2.length;
    merge(nums1,m,nums2,n);
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        //compare the arrays in reverse order and fill nums1 from end
        while(m>0 && n>0){
            nums1[m+n-1]=nums1[m-1]>nums2[n-1]?nums1[--m] :nums2[--n];
        }
        //if elements in nums1 get exhausted
        while (n>0)
            nums1[--n]=nums2[n];
        //print he merged array
        System.out.println(Arrays.toString(nums1));
    }
}
