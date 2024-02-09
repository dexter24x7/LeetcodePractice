package Maths;

import java.util.HashMap;
import java.util.Map;

//593. Valid Square
/*
Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.
The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.
A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 */
public class ValidSquare {
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, Integer> map = new HashMap<>();
        int res=distance(p1,p2);
        map.put(res, map.getOrDefault(res,0)+1);
        res=distance(p1,p3);
        map.put(res, map.getOrDefault(res,0)+1);
        res=distance(p1,p4);
        map.put(res, map.getOrDefault(res,0)+1);
        res=distance(p2,p3);
        map.put(res, map.getOrDefault(res,0)+1);
        res=distance(p3,p4);
        map.put(res, map.getOrDefault(res,0)+1);
        res=distance(p4,p2);
        map.put(res, map.getOrDefault(res,0)+1);

        if(map.size()==2){
            int sum=0;
            int prod=1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getKey() ==0) return false;
                sum+=entry.getValue();
                prod*=entry.getValue();
            }
            return sum == 6 && prod == 8;
        }
        return false;
    }


    public static boolean validSquare1(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d1=distance(p1,p2);
        if(d1==0 || d1!=distance(p4,p3)) return false;
        int d2=distance(p2,p3);
        if(d2==0 || d2!=distance(p1,p4)) return false;
        int d3=distance(p1,p3);
        if(d3==0 || d3!=distance(p2,p4)) return false;
        return d1 == d2 || d2 == d3 || d3 == d1;
    }

    static int distance(int[] p1, int[] p2){
        return (int)Math.pow((p1[0]-p2[0]), 2) + (int)Math.pow((p1[1]-p2[1]), 2);
    }

    public static void main(String[] args) {
        int[] p1 ={0,0};
        int[] p2={1,1};
        int[] p3={1,0};
        int[] p4={0,1};
        System.out.println(validSquare(p1,p2,p3,p4));
        System.out.println(validSquare1(p1,p2,p3,p4));
    }
}
