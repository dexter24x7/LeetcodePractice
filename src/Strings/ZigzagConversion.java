package Strings;
//6. Zigzag Conversion
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P     I     N
A   L S   I G
Y A   H R
P     I
And then read line by line: "PINALSIGYAHRPI"
Write the code that will take a string and make this conversion given a number of rows.
 */
public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        if(numRows==1 || numRows>=s.length()) return s;
        StringBuilder sb = new StringBuilder();
        for(int row=0; row<numRows; row++){
            int jump=2*(numRows-1);
            for(int pos=row; pos<s.length(); pos+=jump){
                sb.append(s.charAt(pos));
                if(row>0 && row<numRows-1 && (pos+jump-2*row)<s.length()){
                    sb.append(s.charAt(pos+jump-2*row));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert(s,numRows));
    }
}
