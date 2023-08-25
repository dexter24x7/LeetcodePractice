package Arrays;
//1423. Maximum Points You Can Obtain from Cards
/*
There are several cards arranged in a row, and each card has an associated number of points.
The points are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 */
public class MaximumPointsYouCanObtainFromCards {
    public static int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        for(int i=1; i<len; i++){
            cardPoints[i] += cardPoints[i-1];
        }
        if(len==k) return cardPoints[len-1];
        int ans = cardPoints[len-k-1];
        for(int i=0; i<k; i++){
            ans = Math.min(ans,cardPoints[i+(len-k)]-cardPoints[i]);
        }
        return cardPoints[len-1]-ans;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println("The maximum score that can obtained is: "+maxScore(cardPoints,k));
    }
}
