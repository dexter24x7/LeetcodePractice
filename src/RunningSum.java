public class RunningSum {
    static int[] runningSum(int[] nums) {
        int size = nums.length;
        for (int i = 1; i < size; i++)
            nums[i]+=nums[i-1];
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {2,3};
        arr = runningSum(arr);
        for (int num:arr) {
            System.out.print(num+", ");
        }
    }
}
