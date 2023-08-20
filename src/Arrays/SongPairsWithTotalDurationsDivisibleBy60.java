package Arrays;
import java.util.HashMap;
//1010. Pairs of Songs With Total Durations Divisible by 60
/*
You are given a list of songs where the ith song has a duration of time[i] seconds.
Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 */

public class SongPairsWithTotalDurationsDivisibleBy60 {
    //Approach 1: HashMap- Space Efficient
    public static int numPairsDivisibleBy60(int[] time) {
        int res=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int t: time){
            if(map.containsKey((60 - t%60)%60)) res+=map.get((60 - t%60)%60);
            map.put(t%60, map.getOrDefault(t%60,0)+1);
        }
        return res;
    }
    //Approach 2: Arrays-Time Efficient
    public static int numPairsDivisibleBy60Arrays(int[] time) {
        int[] rem=new int[60];
        int count=0;
        for(int t:time){
            count+=rem[(60-t%60)%60];
            rem[t%60]++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] time = {15,63,451,213,37,209,343,319};
        System.out.println("Approach1: "+numPairsDivisibleBy60(time));
        System.out.println("Approach2: "+numPairsDivisibleBy60Arrays(time));
    }
}
