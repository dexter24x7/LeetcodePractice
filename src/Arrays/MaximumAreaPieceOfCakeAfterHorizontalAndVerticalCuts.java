package Arrays;

import java.util.Arrays;

//1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
/*
You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:
horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly,
and verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the
arrays horizontalCuts and verticalCuts. Since the answer can be a large number, return this modulo 109 + 7.
 */
public class MaximumAreaPieceOfCakeAfterHorizontalAndVerticalCuts {
    static final int M = 1000000007;
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = Math.max(horizontalCuts[0],h-horizontalCuts[horizontalCuts.length-1]);
        int maxV = Math.max(verticalCuts[0],w-verticalCuts[verticalCuts.length-1]);
        for(int i=1; i<horizontalCuts.length; i++){
            maxH = Math.max(maxH,horizontalCuts[i]-horizontalCuts[i-1]);
        }
        for(int i=1; i<verticalCuts.length; i++){
            maxV = Math.max(maxV,verticalCuts[i]-verticalCuts[i-1]);
        }

        return (int)(((long)maxH*maxV)%M);
    }

    public static void main(String[] args) {
        int h =1000000000, w = 1000000000;
        int[] horizontalCuts = {2}, verticalCuts = {2};
        System.out.println(maxArea(h,w,horizontalCuts,verticalCuts));
    }
}
