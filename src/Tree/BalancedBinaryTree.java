package Tree;
//110. Balanced Binary Tree
/*
Given a binary tree, determine if it is height-balanced.
 */
public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        int height = dfs(root);
        return height!=-1;
    }
    static int dfs(TreeNode root){
        if(root == null) return 0;
        int hLeft = dfs(root.left);
        int hRight = dfs(root.right);
        if(hLeft==-1 || hRight==-1) return -1;
        if(Math.abs(hRight-hLeft)>1)return -1;
        return Math.max(hLeft, hRight)+1;
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] input = new int[]{3,9,20,0,0,15,7};
        bt.root = bt.insertLevelOrder(input,0);
        System.out.println(isBalanced(bt.root));
    }
}
