import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
    int[] nums1= {1,2,3,0,0,0};
    int[] nums2= {2,5,6};
    int m=nums1.length-nums2.length, n= nums2.length;
    merge(nums1,m,nums2,n);
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m+n; i++)
                nums1[i] = nums2[i-m];
        Arrays.sort(nums1);
        System.out.print("[");
        for (int num : nums1)
            System.out.print(num+", ");
        System.out.println("]");
    }
}
