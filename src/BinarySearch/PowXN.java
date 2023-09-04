package BinarySearch;
//50. Pow(x, n)
/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */
public class PowXN {
    public static double myPow(double x, long n) {
        if(n<0){
            x=1/x;
            n = -n;
        }
        double res =1;
        while(n>0){
            if(n%2==1){
                res*=x;
                n--;
            }
            x*=x;
            n = n/2;
        }
        return res;
    }

    public static void main(String[] args) {
        double x= 2.00000;
        int n = -2147483648;
        System.out.println(myPow(x,n));
    }
}
