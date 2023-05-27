package Graphs;
//797. All Paths From Source to Target
/*
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
find all possible paths from node 0 to node n - 1 and return them in any order.
The graph is given as follows: graph[i] is a list of all nodes you can visit
from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */
import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0,graph,res,list);
        return res;
    }

    public void dfs(int root,int[][] graph,List<List<Integer>> res, List<Integer> list){
        //checking if we have reached destination
        if(root == graph.length-1){
            //add a copy of the current list to result
            res.add(new ArrayList<>(list));
            return;
        }
        //for all the neighbours of root
        for(int e: graph[root]){
            list.add(e);
            dfs(e,graph,res,list);
            //removes the last added element
            list.remove(list.size()-1);
        }
    }
}
