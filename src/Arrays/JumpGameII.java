package Arrays;
//45. Jump Game II
/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
if you are at nums[i], you can jump to any nums[i + j] where:
0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you
can reach nums[n - 1].
 */
public class JumpGameII {
    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length; i++) dp[i]=Integer.MAX_VALUE;
        dp[nums.length-1] = 0;
        for(int i=nums.length-2; i>=0; i--){
            for(int j=1; j<=nums[i];j++){
                if ((i + j) < nums.length && dp[i + j]< dp[i]-1) {
                    dp[i] = dp[i + j]+1;
                }
            }
        }
        return dp[0];
    }
    public static int jump1(int[] nums) {
        int jump=0, curr=0, maxJump=0;
        for(int i=0; i<nums.length-1; i++){
            maxJump = Math.max(maxJump, nums[i]+i);
            if(i==curr){
                jump++;
                curr = maxJump;
            }
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
        System.out.println(jump1(nums));
    }
}
