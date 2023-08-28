package Tree;
//530. Minimum Absolute Difference in BST
/*
Given the root of a Binary Search Tree (BST),
return the minimum absolute difference between the values of any two different nodes in the tree.
 */
public class MinimumAbsoluteDifferenceInBST {
    static int diff=Integer.MAX_VALUE;
    static int prev = -100000;
    public static int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return diff;
    }
    private static void inOrderTraversal(TreeNode root){
        if (root == null) return;
        inOrderTraversal(root.left);
        diff = Math.min(diff, root.val-prev);
        prev = root.val;
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] input = new int[]{4,2,6,1,3};
        bt.root = bt.insertLevelOrder(input,0);
        System.out.println(getMinimumDifference(bt.root));
    }
}
