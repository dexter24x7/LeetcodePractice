package Maths;
//67. Add Binary
/*
Given two binary strings a and b, return their sum as a binary string.
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int carry=0;
        StringBuilder res = new StringBuilder();
        while(lenA>0 || lenB>0){
            int sum = carry;
            if(lenA>0) sum+=a.charAt(--lenA)-'0';
            if(lenB>0) sum+=b.charAt(--lenB)-'0';
            carry = sum>1?1:0;
            res.append(sum%2);
        }
        if(carry>0) res.append(1);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(addBinary(a,b));
    }
}
