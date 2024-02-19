package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//133. Clone Graph
/*
Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
class CloneGraph {
    private static final Map<Node, Node> cloneMap = new HashMap<>();
    public static Node cloneGraph(Node node) {
        if(node==null) return null;

        if (cloneMap.containsKey(node)) {
            return cloneMap.get(node);
        }
        Node copy = new Node(node.val);
        if(node.neighbors.isEmpty()){
            return copy;
        }
        cloneMap.put(node, copy);

        for(Node neighbor: node.neighbors){
            copy.neighbors.add(cloneGraph(neighbor));
        }
        return copy;
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        System.out.println(cloneGraph(root));

    }
}

class Node {
    public final int val;
    public final List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
