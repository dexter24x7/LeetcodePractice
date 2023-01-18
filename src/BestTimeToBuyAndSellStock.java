public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int maxProfit=0,min=prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>min)
                maxProfit = Math.max(maxProfit, (prices[i] - min));
            else min=prices[i];
        }
    return maxProfit;
    }

}
