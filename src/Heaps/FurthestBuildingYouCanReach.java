package Heaps;

import java.util.PriorityQueue;

//1642. Furthest Building You Can Reach
/*
You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
While moving from building i to building i+1 (0-indexed),
If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 */
public class FurthestBuildingYouCanReach {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> usedLadder = new PriorityQueue<>();

        for(int i=1;i<heights.length; i++){
            int currHeight=heights[i] - heights[i-1];
            if(currHeight<=0) continue;

            usedLadder.add(currHeight);
            if(usedLadder.size()<=ladders) continue;

            else if((bricks-= usedLadder.poll())<0) return i-1;
        }
        return heights.length-1;
    }

    public static void main(String[] args) {
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5, ladders = 1;
        System.out.println(furthestBuilding(heights,bricks,ladders));
    }
}
