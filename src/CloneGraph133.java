
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph133 {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        buildMapDfs(node, map);
        clone(map);
        return map.get(node);
    }

    void clone(Map<Node, Node> map) {
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            entry.getValue().neighbors = new ArrayList<>(); // initialize the neighbors of new node
            for (Node origCurr : entry.getKey().neighbors) { // loop through orig node neighbors
                entry.getValue().neighbors.add(map.get(origCurr)); // for each of orig neighbor, find the corresponding new node in map and set it as new node's neighbors
            }
        }
    }

    // create map of (original node, new node) using dfs
    void buildMapDfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return;
        }

        map.put(node, new Node(node.val));
        for (Node curr : node.neighbors) {
            buildMapDfs(curr, map);
        }
    }
}

class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
