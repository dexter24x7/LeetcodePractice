//62. Unique Paths
/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m=6, n=6;
//        System.out.println("Brute Force Approach");
//        System.out.println(uniquePaths(m-1,n-1));
        System.out.println("Optimised Approach");
        System.out.println(uniquePaths2(m-1,n-1));
    }
    //brute force approach
    static int uniquePaths(int m, int n){
        int count =0;
        if (m<=0&&n<=0)
            return 1; //All steps complete
        if (m>=1)
            count+= uniquePaths(m-1,n);
        if (n>=1)
            count+= uniquePaths(m,n-1);
        return count;
    }
    //Optimised approach
    static int uniquePaths2(int m, int n){
        double res =1;
        for (int i = 1; i <= m+n; i++) {
            if (i<=m)
                res/=i;
            if (i>n)
                res*=i;
        }
        return (int)Math.round(res);
    }
}
