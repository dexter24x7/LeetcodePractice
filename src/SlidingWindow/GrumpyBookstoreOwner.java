package SlidingWindow;
//1052. Grumpy Bookstore Owner
/*
There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an
integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute
and all those customers leave after the end of that minute. On some minutes, the bookstore owner is grumpy. You are given a binary array
grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise. When the bookstore owner is grumpy,
the customers of that minute are not satisfied, otherwise, they are satisfied. The bookstore owner knows a secret technique to keep
themselves not grumpy for minutes consecutive minutes, but can only use it once. Return the maximum number of customers that can be
satisfied throughout the day.
 */
public class GrumpyBookstoreOwner {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied=0;
        for(int i=0; i<customers.length;i++){
            if(grumpy[i]==0) satisfied+=customers[i];
        }
        int start=0, end=0;
        while(end<minutes){
            if(grumpy[end]==1) satisfied+=customers[end];
            end++;
        }
        int max=satisfied;
        while(end<customers.length){
            if(grumpy[start]==1) satisfied-=customers[start];
            start++;
            if(grumpy[end]==1) satisfied+=customers[end];
            end++;
            max = Math.max(satisfied,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5}, grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers,grumpy,minutes));
    }
}
