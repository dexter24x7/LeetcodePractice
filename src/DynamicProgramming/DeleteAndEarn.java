package DynamicProgramming;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

//740. Delete and Earn
/*
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.
 */
public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> count = new TreeMap<>();
        for(int num: nums) count.put(num, count.getOrDefault(num,0)+1);
        ArrayList<Integer> list =new ArrayList<>(count.keySet());
        int earn1=0;
        int earn2=0;
        for(int i=0; i<list.size(); i++){
            int currEarn = list.get(i)*count.get(list.get(i));
            int temp;
            if(i>0 && list.get(i) == list.get(i-1)+1){
                temp = earn2;
                earn2 = Math.max(earn1+currEarn, earn2);
                earn1 = temp;
            }
            else{
                temp = earn2;
                earn2 = earn2+currEarn;
                earn1 = temp;
            }
        }
        return earn2;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,3,3,4};
        System.out.println(deleteAndEarn(nums));
    }
}
