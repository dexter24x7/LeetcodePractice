//118. Pascal's Triangle
/*
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it.
     1
    1  1
   1  2  1
  1  3  3  1
 1  4  6  4  1
1  5 10 10  5  1

 */
import java.util.*;
public class PascalsTriangle {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the number of rows:");
        int numRows= sc.nextInt();
        List<List<Integer> > pascalTriangle;
        pascalTriangle = generate(numRows);
        System.out.println(pascalTriangle);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer> > pascalTriangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
        List<Integer> temp  = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i)
                    temp.add(j,1);
                else
                    temp.add(j,pascalTriangle.get(i-1).get(j)+pascalTriangle.get(i-1).get(j-1));
            }
            pascalTriangle.add(temp);
        }
        return pascalTriangle;
    }
}
