package Arrays;//56. Merge Intervals
/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{6,7},{1,3},{4,5}};

        System.out.println(Arrays.deepToString(merge(intervals)));
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));
        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int pos=0;
        for (int i = 1; i < intervals.length; i++) {
            if (res[pos][1]>=intervals[i][0]) {
                res[pos][0]= Math.min(res[pos][0], intervals[i][0]);
                res[pos][1]= Math.max(res[pos][1], intervals[i][1]);
            }
            else {
                pos++;
                res[pos][0]= intervals[i][0];
                res[pos][1]= intervals[i][1];
            }
        }
        int[][] trimArray = new int[pos+1][2];
        for (int i = 0; i <= pos; i++) {
            System.arraycopy(res[i], 0, trimArray[i], 0, 2);
        }
        return trimArray;
    }
}
