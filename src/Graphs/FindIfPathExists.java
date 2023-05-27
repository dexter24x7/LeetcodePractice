package Graphs;
//1971. Find if Path Exists in Graph
/*
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes
a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge,
and no vertex has an edge to itself.
You want to determine if there is a valid path that exists from vertex source to vertex destination.
Given edges and the integers n, source, and destination, return true if there is a valid path from source
to destination, or false otherwise.
 */


public class FindIfPathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        /*Create a parent array from the given edges
         *check if the parent of the source and destination are same
         *return true if same else return false
         */

        //defining parent array
        int[] parent = new int[n];

        //initializing parent array
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        //updating the parent array from edges[][]
        for(int[] edge : edges){
            parent[findParent(edge[1],parent)] = findParent(edge[0],parent);
        }

        //checking if the parents of source and destination are same
        return findParent(source,parent) == findParent(destination,parent);
    }

    int findParent(int x, int[] parent){
        if(parent[x] != x)
            parent[x] = findParent(parent[x],parent);
        return parent[x];
    }
}
