import java.util.Scanner;
public class NumberPalindrome {
    public static boolean isNumberPalindrome(int x){
        if (x<0) return false;
        int copy = x;
        int number = 0;
        while (copy!=0){
            number = number*10 + copy%10;
            copy/=10;
        }
        return number == x;
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number:");
    int x= sc.nextInt();
        System.out.println(isNumberPalindrome(x));
    }
}
