package class07;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {
    public static void main(String[] args) {

    }

    public static class EdgeComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> primMST(Graph graph){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());

        Set<Edge> result = new HashSet<>();
        HashSet<Node> set = new HashSet<>();

        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)){
                set.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }

                while (!priorityQueue.isEmpty()){
                    Edge cur = priorityQueue.poll();
                    Node toNode = cur.to;
                    if (!set.contains(toNode)){
                        set.add(toNode);
                        result.add(cur);
                        for (Edge edge : toNode.edges) {
                            priorityQueue.add(edge);
                        }
                    }
                }
            }
        }
        return result;
    }
}
