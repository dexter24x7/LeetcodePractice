package Hashing;

import java.util.*;

//347. Top K Frequent Elements
/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentElements {
    //Approach 1 -> nlog n
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((x, y) -> (y.getValue()-x.getValue()));
        heap.addAll(map.entrySet());
        int[] res = new int[k];
        for(int i = 0; i<k;i++)
            res[i] = heap.poll().getKey();
        return res;
    }
    //Approach 2 -> O(n) Bucket Sort
    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //counting frequencies
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        //adding keys at the index of their count
        ArrayList<Integer>[] bucketSort = new ArrayList[nums.length];
        for(int i=0; i<nums.length; i++) bucketSort[i] = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            bucketSort[entry.getValue()-1].add(entry.getKey());
        }

        //traverse in reverse order on the bucket sort array and fetch the first K elements
        int[] res = new int[k];
        for(int i = nums.length-1; i>=0; i--){
            for(int ele: bucketSort[i]){
                if(k==0) break;
                res[--k] = ele;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));
        System.out.println(Arrays.toString(topKFrequent2(nums,k)));
    }
}
