package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

//973. K Closest Points to Origin
/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return
the k closest points to the origin (0, 0). The distance between two points on the X-Y plane is the Euclidean distance
(i.e., √(x1 - x2)2 + (y1 - y2)2). You may return the answer in any order. The answer is guaranteed to be unique
(except for the order that it is in).
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        //queue to store the points in a heap based on distance from origin
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(this::distance);
        for(int[] point : points){
            queue.add(new Integer[]{point[0], point[1]});
        }

        //res to store k closest points
        int[][] res = new int[k][2];

        //first k points in the priority queue are the required points
        for(int i=0; i<k && !queue.isEmpty() ; i++){
            res[i] = new int[]{queue.peek()[0],queue.poll()[1]};
        }
        return res;
    }
    //returns the difference of distances of two points from origin
    int distance(Integer[] x,Integer[] y){
        int xd =  (int)(Math.pow(x[0],2) + Math.pow(x[1],2));
        int yd =  (int)(Math.pow(y[0],2) + Math.pow(y[1],2));
        return xd-yd;
    }

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
        System.out.println(Arrays.deepToString(obj.kClosest(points,k)));
    }
}
