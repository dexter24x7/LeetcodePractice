package Heaps;

import java.util.PriorityQueue;

//378. Kth Smallest Element in a Sorted Matrix
/*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.
You must find a solution with a memory complexity better than O(n2).
 */
public class KthSmallestElementInSortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] ints : matrix) {
            for (int num : ints) {
                queue.add(num);
            }
        }

        while(!queue.isEmpty() && k>1){
            queue.poll();
            k--;
        }
        return queue.isEmpty()?-1:queue.poll();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println(kthSmallest(matrix,k));
    }
}
