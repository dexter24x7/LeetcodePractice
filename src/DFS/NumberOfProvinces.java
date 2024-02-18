package DFS;

import java.util.HashSet;
import java.util.Set;

//547. Number of Provinces
/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.
 */
public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        for(int i=0; i<parent.length; i++) parent[i] = i;

        for(int i=0; i< isConnected.length; i++){
            for(int j=i+1; j<isConnected.length; j++){
                if(isConnected[i][j] == 1){
                    int p= j;
                    while(parent[p]!=p){
                        parent[p] = parent[parent[p]];
                        p=parent[p];
                    }
                    int q=i;
                    while(parent[q]!=q){
                        parent[q] = parent[parent[q]];
                        q=parent[q];
                    }
                    parent[p] = parent[q];
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<parent.length; i++){
            int j=i;
            while(parent[j]!=j){
                parent[j]=parent[parent[j]];
                j=parent[j];
            }
            set.add(j);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[][] isConnected={{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(findCircleNum(isConnected));
    }
}
