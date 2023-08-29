package Tree;

import java.util.ArrayList;
import java.util.List;

//94. Binary Tree Inorder Traversal
/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrderTraversal(root, res);
        return res;
    }
    static void inOrderTraversal(TreeNode root,List<Integer> res){
        if(root == null) return;
        inOrderTraversal(root.left, res);
        res.add(root.val);
        inOrderTraversal(root.right, res);
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] input = new int[]{3,9,20,0,0,15,7};
        bt.root = bt.insertLevelOrder(input,0);
        System.out.println(inorderTraversal(bt.root));
    }
}
