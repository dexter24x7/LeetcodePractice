//724. Find Pivot Index
/*
Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the
index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because there are
no elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.
 */
public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex2(nums));
    }
    public static int pivotIndex(int[] nums) {
        int size = nums.length;
        int[] forwardSum =new int[size];
        forwardSum[0]=nums[0];
        for (int i = 1; i < size; i++) {
            forwardSum[i]=forwardSum[i-1]+nums[i];
        }
        int totalSum = forwardSum[size-1];
        if (totalSum-forwardSum[0]==0)
            return 0;
        for (int i = 1; i < size-1; i++) {
            if (forwardSum[i-1]==totalSum-forwardSum[i])
                return i;
        }
        if (forwardSum[size-2]==0)
            return size-1;
    return -1;
    }
    public static int pivotIndex2(int[] nums) {
        int sum=0, leftSum=0;
        for (int x: nums) sum+=x;
        for (int i = 0; i < nums.length; i++) {
            if (2*leftSum==sum-nums[i]) return i;
            leftSum+=nums[i];
        }
        return -1;
    }
}
