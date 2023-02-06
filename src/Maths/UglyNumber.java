package Maths;//import java.sql.SQLOutput;
import java.util.Scanner;

public class UglyNumber {
    public static boolean isUgly(int n){
        boolean ugly = false;
        if (n<=0) return ugly;
        while(n%5==0) n/=5;
        while(n%3==0) n/=3;
        while(n%2==0) n/=2;
        if (n==1) ugly = true;
        return ugly;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int number = sc.nextInt();
        if(isUgly(number)){
            System.out.println("Ugly Number");
        }
        else System.out.println("Not an Ugly number");

    }
}
