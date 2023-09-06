package Heaps;
import java.util.Arrays;

//787. Cheapest Flights Within K Stops
/*
There are n cities connected by some number of flights. You are given an array flights where
flights[i] = [from-i, to-i, price-i] indicates that there is a flight from city from-i to city to-i with cost price-i.
You are also given three integers src, dst, and k, return the cheapest price from src to dst
with at most k stops. If there is no such route, return -1.
 */
public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[src] =0;
        for(int i=0; i<=k; i++){
            int[] dpCopy = new int[n];
            System.arraycopy(dp,0,dpCopy,0,n);
            for(int[] flight: flights){
                if(dp[flight[0]]==Integer.MAX_VALUE) continue;
                dpCopy[flight[1]] = Math.min(dpCopy[flight[1]],dp[flight[0]]+flight[2]);
            }
            System.arraycopy(dpCopy,0,dp,0,n);
        }
        return dp[dst]!=Integer.MAX_VALUE?dp[dst]:-1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(findCheapestPrice(n,flights,src,dst,k));
    }
}
