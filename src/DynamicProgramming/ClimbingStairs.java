package DynamicProgramming;
//70. Climbing Stairs
/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
public class ClimbingStairs {
    public static int climbStairs(int n) {
        return counter(n, new int[n+1]);
    }

    public static int counter(int n, int[] cache){

        if(n<2) return 1;
        if(cache[n]!=0){
            return cache[n];
        }
        cache[n] =  counter(n-1,cache) + counter(n-2,cache);
        return cache[n];
    }

    public static void main(String[] args) {
        int numStairs = (int) (Math.random() * 44) +1; // 1 to 45 stairs
        System.out.println("Number of ways to climb "+numStairs+" is: "+climbStairs(numStairs));
    }
}
