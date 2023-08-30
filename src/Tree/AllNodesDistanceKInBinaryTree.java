package Tree;

import java.util.*;

//863. All Nodes Distance K in Binary Tree
/*
Given the root of a binary tree, the value of a target node target, and an integer k,
return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.
 */
public class AllNodesDistanceKInBinaryTree {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
        Set<TreeNode> isVisited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        findParent(root, parentMap);
        // System.out.println(parentMap.get(root.left));
        q.add(target);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i<len; i++){
                TreeNode curr = q.poll();
                isVisited.add(curr);
                if(k==0) res.add(curr.val);
                if(curr.left != null && !isVisited.contains(curr.left)) q.add(curr.left);
                if(curr.right != null && !isVisited.contains(curr.right)) q.add(curr.right);
                TreeNode parent = parentMap.get(curr);
                if(parent!=null && !isVisited.contains(parent)) q.add(parent);
            }
            k--;
            if(k<0) break;
        }
        return res;
    }
    static void findParent(TreeNode root, HashMap<TreeNode,TreeNode> parentMap){
        if(root == null) return;
        if(root.left !=null) parentMap.put(root.left, root);
        if(root.right !=null) parentMap.put(root.right, root);
        findParent(root.left, parentMap);
        findParent(root.right, parentMap);
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] input = new int[]{3,5,1,6,2,0,8,0,0,7,4};
        bt.root = bt.insertLevelOrder(input,0);
        int k=2;
        TreeNode target = new TreeNode(5);
        System.out.println(distanceK(bt.root, target,k));
    }
}
