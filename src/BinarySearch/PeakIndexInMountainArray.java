package BinarySearch;
//852. Peak Index in a Mountain Array
/*
An array arr is a mountain if the following properties hold:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

You must solve it in O(log(arr.length)) time complexity.
 */
public class PeakIndexInMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int left=0, right = arr.length-1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]) return mid;
            else if(arr[mid-1]<arr[mid]) left = mid;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 2, 0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
