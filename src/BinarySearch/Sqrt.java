package BinarySearch;

//69. BinarySearch.Sqrt(x)
/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }
    public static int mySqrt(int x) {
        int high=x,low=0;
        while(high>=low){
            int mid = low + (high-low)/2;
            if((x >= (long)mid*mid) && (x < (long)(mid+1)*(mid+1))) return mid;
            else if (x> (long)mid*mid) low = mid+1;
            else high = mid-1;
        }
        return high;
    }
}
