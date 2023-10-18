package Arrays;
//724. Find Pivot Index
/*
Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to
the left of the index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because there are no
elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.

 */
public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int size = nums.length;
        int[] forwardSum =new int[size+1];
        forwardSum[0]=0;
        for (int i = 0; i < size; i++) {
            forwardSum[i+1]=forwardSum[i]+nums[i];
        }
        int totalSum = forwardSum[size];
        for (int i = 0; i < size; i++) {
            if (forwardSum[i]==totalSum-forwardSum[i+1])
                return i;
        }
        if (forwardSum[size-1]==0)
            return size-1;

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}
