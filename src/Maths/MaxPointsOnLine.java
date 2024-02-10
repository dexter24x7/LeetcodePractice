package Maths;
//149. Max Points on a Line
/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 */
import java.util.HashMap;

public class MaxPointsOnLine {
    public static int maxPoints(int[][] points) {
        int max=1;
        for(int i=0; i<points.length-1; i++){
            HashMap<Double, Integer> map = new HashMap<>();
            for(int j=i+1; j<points.length; j++){
                double slope;
                if(points[j][0] == points[i][0]) slope=Double.POSITIVE_INFINITY;
                else
                    slope = (double)(points[j][1]-points[i][1])/(double)(points[j][0]-points[i][0]);
                if(slope==-0.0) slope=0;
                map.put(slope, map.getOrDefault(slope,1)+1);
            }
            for(int count: map.values()){
                max = Math.max(count, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] points = { {9, 7}, {2, 5}, {8, 4}, {6, 1}, {3, 9}, {7, 2} };
        System.out.printf("The maximum number of points that lie on the same straight line are %d.",maxPoints(points));
    }
}
