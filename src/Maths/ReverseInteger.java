package Maths;
import java.util.Scanner;

public class ReverseInteger {
    //7. Reverse Integer
    /*
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes
    the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     */
    public static int reverse(int x) {
        int revNum = 0;
        while (x!=0){
            int digit = x%10;
            x = x/10;
            if(revNum > Integer.MAX_VALUE/10 ||
                    revNum == Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE%10)
                return 0;
            if(revNum < Integer.MIN_VALUE/10 ||
                    revNum == Integer.MIN_VALUE/10 && digit>Integer.MAX_VALUE%10)
                return 0;
            revNum = revNum*10+digit;
        }
        return revNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to be reversed: ");
        int num = sc.nextInt();
        int revNum = reverse(num);
        System.out.println("The reversed number is "+revNum);
    }
}
