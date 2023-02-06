package Arrays;//509. Fibonacci Number
/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).
 */
import java.util.Scanner;

public class FibonacciNumbers {
    public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
        System.out.println("Enter the index of Fibonacci term: ");
        int n = sc.nextInt();
        System.out.println(fib(n));
        System.out.println(fib2(n));
    }
    //Recursion Approach
    public static int fib(int n) {
    if (n<=1) return n;
    return fib(n-1)+fib(n-2);
    }
    //Iterative Approach
    public static int fib2(int n) {
        if(n<=1) return n;
        int a=0, b=1,temp=0;
        for (int i = 2; i <=n; i++) {
            temp=b;
            b=a+b;
            a=temp;
        }
        return b;
    }
    //good code for reference from net
    public int fib3(int n) {
        if (n < 0 || n > 30) throw new RuntimeException("illegal input!");
        if (n <= 1) return n;
        int[] arr = new int[2];
        arr[0] = 1;//fib(1)
        arr[1] = 1;//fib(2)

        for (int i = 3; i <= n; i++) {
            arr[i % 2] = arr[(i - 1) % 2] + arr[(i - 2) % 2]; //This part is awesome!
        }
        return arr[n % 2];
    }
}

