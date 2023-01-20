//283. Move Zeroes
/*Given an integer array numbers, move all 0's to the end of it while maintaining the relative order of the non-zero elements.*/
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,0,1};
        moveZeroes(nums);
        }
    static void moveZeroes(int[] nums) {
        int zeroInd=0;
        for (int i = 0; i< nums.length; i++)
            if (nums[i]!=0){
                if (i==zeroInd)
                    zeroInd++;
                else {
                    nums[zeroInd] = nums[i];
                    zeroInd++;
                    nums[i] = 0;
                }
            }
        //print statement to verify ans
        for (int num :
                nums) {
            System.out.print(num+" ");
        }
    }
}
