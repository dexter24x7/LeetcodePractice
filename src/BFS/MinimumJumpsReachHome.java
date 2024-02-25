package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//1654. Minimum Jumps to Reach Home
/*
A certain bug's home is on the x-axis at position x. Help them get there from position 0.
The bug jumps according to the following rules:
It can jump exactly a positions forward (to the right).
It can jump exactly b positions backward (to the left).
It cannot jump backward twice in a row.
It cannot jump to any forbidden positions.
The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.
Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.
 */
public class MinimumJumpsReachHome {
    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<Integer> bfs = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for(int ele: forbidden) visited.add(ele);
        bfs.offer(0);
        visited.add(0);
        int jump=0;
        while(!bfs.isEmpty()){
            int queue = bfs.size();
            while(queue-->0){
                boolean flag = bfs.peek()<0;
                int curr = Math.abs(bfs.poll());

                if(curr==x) return jump;

                int back = curr-b;
                if(back>0 && !visited.contains(back) && !flag){
                    bfs.offer(-back);
                    visited.add(back);
                }

                int fwd = curr+a;
                if(fwd<=6000 && !visited.contains(fwd)){
                    bfs.offer(fwd);
                    visited.add(fwd);
                }
            }
            jump++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] forbidden = new int[]{14,4,18,1,15};
        int a = 3;
        int b = 15;
        int x = 9;
        System.out.printf("The minimum number of jumps for the bug to reach %d is %d",x,minimumJumps(forbidden,a,b,x));
    }
}
