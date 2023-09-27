package Maths;
//168. Excel Sheet Column Title
/*
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 */
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            title.append((char)('A'+columnNumber%26));
            columnNumber/=26;
        }
        return title.reverse().toString();
    }

    public static void main(String[] args) {
        int columnNumber = 701;
        System.out.println(convertToTitle(columnNumber));
    }
}
