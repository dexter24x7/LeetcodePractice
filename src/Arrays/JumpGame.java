package Arrays;
//55. Jump Game
/*
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame {
    //DP Solution
    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length-1] = true;
        for(int i=nums.length-2; i>=0; i--){
            for(int j=1; j<=nums[i];j++){
                if ((i + j) < nums.length && dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    //Greedy Solution
    public static boolean canJump2(int[] nums) {
        int index = nums.length-1;
        for(int i=nums.length-1; i>=0; i--){
            if(i+nums[i]>=index) index=i;
        }
        return index==0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
        System.out.println(canJump2(nums));
    }
}
