package Grind75;

import java.sql.Array;
import java.util.*;

public class _32_CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        if(node == null) {
            return null;
        }
        Node nodeCopy = new Node(node.val);
        map.put(node, nodeCopy);
        createDuplicate(node, nodeCopy, map);
        return nodeCopy;
    }

    private void createDuplicate(Node node, Node nodeCopy, Map<Node, Node> map) {
        map.put(node, nodeCopy);

        for(Node neighbor: node.neighbors) {
            if(map.containsKey(neighbor)) {
                nodeCopy.neighbors.add(map.get(neighbor));
            } else {
                Node neighborCopy = new Node(neighbor.val);
                nodeCopy.neighbors.add(neighborCopy);
                createDuplicate(neighbor, neighborCopy, map);
            }
        }
    }
}
