package Tree;
//1448. Count Good Nodes in Binary Tree
/*
Given a binary tree root, a node X in the tree is named good if in the path
from root to X there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.
 */
public class CountGoodNodesInBinaryTree {
    public static int goodNodes(TreeNode root) {
        int[] res = {0};
        traverse(root, res, root.val);
        return res[0];
    }
    static void traverse(TreeNode root,int[] res, int max){
        if(root == null) return;
        if(root.val>=max){
            max = root.val;
            res[0]++;
        }
        traverse(root.left, res, max);
        traverse(root.right, res, max);
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] input = new int[]{-1,5,-2,4,4,2,-2,0,0,-4,0,-2,3,0,-2,0,0,-1,0,-3,0,-4,-3,3,0,0,0,0,0,0,0,3,-3};
        bt.root = bt.insertLevelOrder(input,0);
        System.out.println(goodNodes(bt.root));
    }
}
