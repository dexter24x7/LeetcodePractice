package Tree;

import java.util.ArrayList;
import java.util.List;

//144. Binary Tree Preorder Traversal
/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
public class BinaryTreePreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        traversal(preorder,root);
        return preorder;
    }
    static void traversal(List<Integer> preorder, TreeNode root){
        if(root == null) return;
        preorder.add(root.val);
        traversal(preorder,root.left);
        traversal(preorder,root.right);
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] input = new int[]{6,2,8,0,4,7,9,3,5};
        bt.root = bt.insertLevelOrder(input,0);
        System.out.println(preorderTraversal(bt.root));

    }
}
