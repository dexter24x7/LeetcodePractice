package Maths;
//171. Excel Sheet Column Number
/*
Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
 */
public class ExcelSheetColumnNumber {
    public static int titleToNumber(String columnTitle) {
        int res=0;
        for(char letter: columnTitle.toCharArray()){
            res=res*26+letter-'A'+1;
        }
        return res;
    }

    public static void main(String[] args) {
        String columnTitle = "ABC";
        System.out.printf("The corresponding column number for title %s is %d",columnTitle,titleToNumber(columnTitle));
    }
}
