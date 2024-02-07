package Maths;
//43. Multiply Strings
/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        int x = num1.length();
        int y = num2.length();
        int[] res = new int[x+y];

        for(int i=x-1; i>=0; i--){
            for(int j=y-1; j>=0; j--){
                int product = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum = product + res[i+j+1];
                res[i+j+1] = sum%10;
                res[i+j] += sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int digit: res){
            if(sb.isEmpty() && digit==0) continue;
            sb.append(digit);
        }
        return sb.isEmpty() ?"0":sb.toString();
    }

    public static void main(String[] args) {
        String num1="1249856349442147563198463216";
        String num2="4785643213845163894635893841684416";
        System.out.println(multiply(num1,num2));
    }
}
