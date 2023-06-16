package DynamicProgramming;
//338. Counting Bits
/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
ans[i] is the number of 1's in the binary representation of i.
 */
import java.util.Arrays;

public class CountingBits {
    public static int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0; i<=n; i++){
            int count = 0,j=i;
            while(j>0){
                j = j & (j-1);
                count++;
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = (int)(Math.random()*100000);
        System.out.println(Arrays.toString(countBits(num)));
    }
}
