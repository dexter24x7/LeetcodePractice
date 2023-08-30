package Graphs;

import java.util.*;

//399. Evaluate Division
/*
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi]
and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
Return the answers to all queries. If a single answer cannot be determined, return -1.0.
Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 */
public class EvaluateDivision {
    static class Pair{
        String str;
        double weight;
        Pair(String str, double weight){
            this.str = str;
            this.weight = weight;
        }
    }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];

        //creating adj list for equations with num as key , <den,value> as value
        Map<String, List<Pair>> adj = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            String num = equations.get(i).get(0);
            String den = equations.get(i).get(1);
            adj.putIfAbsent(num,new ArrayList<>());
            adj.putIfAbsent(den,new ArrayList<>());
            adj.get(num).add(new Pair(den,values[i]));
            adj.get(den).add(new Pair(num,1.0/values[i]));
        }

        //calculating the result for each query
        int i=0;
        for(List<String> q : queries){
            res[i++] = bfs(q.get(0),q.get(1),adj);
        }
        return res;
    }
    static double bfs(String src, String dest,Map<String, List<Pair>> adj){
        //if the variable not in adj list return -1
        if(!adj.containsKey(src) || !adj.containsKey(dest)) return -1.0;

        //visited set to prevent cycle
        Set<String> visited = new HashSet<>();
        //bfs queue <den, multiplied weight>
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,1));
        visited.add(src);
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(curr.str.equals(dest)) return curr.weight;
            for(Pair p : adj.get(curr.str)){
                if(!visited.contains(p.str)){
                    q.add(new Pair(p.str,curr.weight*p.weight));
                    visited.add(p.str);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[][] eqnArr = {{"a", "b"}, {"b", "c"}};
        List<List<String>> equations = Arrays.stream(eqnArr).map(Arrays::asList).toList();
        double[] values ={2.0,3.0};
        String[][] queriesArr = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        List<List<String>> queries = Arrays.stream(queriesArr).map(Arrays::asList).toList();
        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }
}
