package Tree;
//404. Sum of Left Leaves
/*
Given the root of a binary tree, return the sum of all left leaves.
A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 */
public class SumOfLeftLeaves {
    static int sum=0;
    public static int sumOfLeftLeaves(TreeNode root) {
        sumOfLeft(root,false);
        return sum;
    }
    public static void sumOfLeft(TreeNode root,boolean flag) {
        if(root==null) return;
        if(flag && root.left==null && root.right == null)
            sum+= root.val;
        sumOfLeft(root.left,true);
        sumOfLeft(root.right,false);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] input = new int[]{3,9,20,0,0,15,7};
        bt.root = bt.insertLevelOrder(input,0);
        System.out.println(sumOfLeftLeaves(bt.root));
    }
}
