package Arrays;

import java.util.LinkedList;
import java.util.Queue;

//1306. Jump Game III
/*
Given an array of non-negative integers arr, you are initially positioned at start index of the array.
When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
Notice that you can not jump outside the array at any time.
 */
public class JumpGameIII {
    //time efficient - DFS
    public static boolean canReach1(int[] arr, int start) {
        if(arr[start]==0) return true;
        boolean[] visited = new boolean[arr.length];
        return dfs(arr,start,visited);
    }
    static boolean dfs(int[] arr, int start,boolean[] visited){
        if(start<0 || start>=arr.length || visited[start])
            return false;
        if(arr[start]==0) return true;
        visited[start] = true;
        return dfs(arr,start-arr[start],visited) || dfs(arr,start+arr[start],visited);
    }

    //space efficient - BFS
    public static boolean canReach(int[] arr, int start) {
        if(arr[start]==0) return true;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.add(start+arr[start]);
        q.add(start-arr[start]);
        visited[start] =true;
        while(!q.isEmpty()){
            int curr = q.remove();
            if(curr>=0 && curr<arr.length && !visited[curr]){
                if(arr[curr]==0) return true;
                q.add(curr+arr[curr]);
                q.add(curr-arr[curr]);
                visited[curr] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;
        System.out.println(canReach1(arr,start));
        System.out.println(canReach(arr,start));
    }
}
