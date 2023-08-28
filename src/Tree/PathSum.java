package Tree;
//112. Path Sum
/*
Given the root of a binary tree and an integer targetSum, return true if the tree has
a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.
 */
public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root,0,targetSum);
    }
    public static boolean pathSum(TreeNode root,int sum, int targetSum) {
        if(root == null) return false;
        sum+=root.val;
        //if it is leaf node check for target
        if(root.left==null && root.right==null) {
            return sum == targetSum;
        }
        boolean b1 = pathSum(root.left,sum, targetSum);
        boolean b2 = pathSum(root.right,sum, targetSum);
        return b1 || b2;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] input = new int[]{5,4,8,11,0,13,4,7,2,0,0,0,1};
        bt.root = bt.insertLevelOrder(input,0);
        int targetSum = 22;
        System.out.print("Tree has a root-to-leaf path such that adding up all the values along the path equals targetSum: ");
        System.out.println(hasPathSum(bt.root,targetSum));
    }
}
