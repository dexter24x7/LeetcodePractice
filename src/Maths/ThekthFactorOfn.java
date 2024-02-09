package Maths;
//1492. The kth Factor of n
/*
You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.
Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.
 */
public class ThekthFactorOfn {
    public static int kthFactor(int n, int k) {
        int count=0;
        for(int i=1; i<=n/2 && count<=k+1; i++){
            if(n%i == 0) count++;
            if (count==k) return i;
        }
        if(count+1==k) return n;
        return -1;
    }

    public static void main(String[] args) {
        int n=12;
        int k=4;
        System.out.printf("The %dth factor of %d is %d",k,n,kthFactor(n,k));
    }
}
