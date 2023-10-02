package DynamicProgramming;
//322. Coin Change
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=0; i<=amount; i++) dp[i] = amount+1; //max value
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            for(int coin: coins){
                if(i-coin >=0)  dp[i] = Math.min(dp[i-coin]+1,dp[i]);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }
}
