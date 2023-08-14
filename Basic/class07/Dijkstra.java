package class07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {
    public static void main(String[] args) {

    }

    public static HashMap<Node,Integer> dijkstra(Node head){
        HashMap<Node,Integer> distanceMap = new HashMap<>();
        HashSet<Node> selectedNodes = new HashSet<>();

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);

        while (minNode != null){
            Integer distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode, distance + edge.weight);
                }else {
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node,Integer> distanceMap, HashSet<Node> selectedNodes){
        Node minNode = null;
        int minDistance = Integer.MIN_VALUE;

        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            Integer distance = entry.getValue();
            if (!selectedNodes.contains(node) && distance < minDistance){
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
