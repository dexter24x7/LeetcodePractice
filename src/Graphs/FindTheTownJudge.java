package Graphs;
import java.util.HashSet;

//997. Find the Town Judge
/*
In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled a-i trusts the person labeled bi.
If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */

public class FindTheTownJudge {
    //Approach 1 : creating graph
    public static int findJudge1(int n, int[][] trust) {
        /* Define two array of hashsets
         * @listGraph: stores the list of trusted individuals
         * @trustGraph: stores the list of trusting individuals
         */
        HashSet<Integer>[] listGraph = new HashSet[n];
        HashSet<Integer>[] trustGraph = new HashSet[n];

        //initializing the lists
        for (int i = 0; i < listGraph.length; i++) {
            listGraph[i] = new HashSet<>();
            trustGraph[i] = new HashSet<>();
        }

        //updating the trusting and trusted graphs
        for(int[] t : trust){
            listGraph[t[0]-1].add(t[1]-1);
            trustGraph[t[1]-1].add(t[0]-1);
        }

        //return if any index has 0 trusted but n-1 trusting individuals
        for(int i = 0; i < listGraph.length; i++){
            if(listGraph[i].isEmpty() && trustGraph[i].size()==(n-1))
                return i+1;
        }
        return -1;
    }

    //Approach 2 : Keeping count of trusted and trusting
    public static int findJudge2(int n, int[][] trust) {
        /* Define two array
         * @listGraph: stores the list of trusted individuals
         * @trustGraph: stores the list of trusting individuals
         */
        int[] listGraph = new int[n];
        int[] trustGraph = new int[n];

        //updating the trusting and trusted graphs
        for(int[] t : trust){
            listGraph[t[0]-1]++;
            trustGraph[t[1]-1]++;
        }

        //return if any index has 0 trusted but n-1 trusting individuals
        for(int i = 0; i < listGraph.length; i++){
            if(listGraph[i]==0 && trustGraph[i]==(n-1))
                return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
    int n = 3;
    int[][] trust = {{1,2},{2,3}};
    int res = findJudge1(n,trust);
    int res1 = findJudge2(n,trust);

    if (res ==-1) System.out.println("The rumor is false; the town judge is not present!");
    else System.out.println("The town judge is the person labelled "+ res);
    System.out.println("The town judge is the person labelled "+ res1);
    }
}
