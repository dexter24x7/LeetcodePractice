package Graphs;

import java.util.Arrays;
import java.util.List;

public class DetectCycleInDirectedGraph {
    public static boolean detectCycle(int v, List<List<Integer>> adj){
        boolean[] vis = new boolean[v];
        boolean[] recS = new boolean[v];
        for (int i = 0; i < v; i++) {
            if(!vis[i]){
                if(dfs(i, adj, vis, recS)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(int i, List<List<Integer>> adj, boolean[] vis, boolean[] recS) {
        vis[i] = true;
        recS[i] = true;
        for(Integer neighbour : adj.get(i)){
            if(!vis[neighbour]){
                if(dfs(neighbour,adj,vis,recS)) return true;
            } else if (recS[i]) {
                return true;
            }
        }
        recS[i]=false;
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{1},{2},{3},{}};
        List<List<Integer>> adj = Arrays.stream(graph).map(row -> Arrays.stream(row).boxed().toList()).toList();
        System.out.println(detectCycle(graph.length,adj));
    }
}
