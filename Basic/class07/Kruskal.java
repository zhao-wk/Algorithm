package class07;

import java.util.*;

public class Kruskal {
    public static void main(String[] args) {

    }

    public static class MySet{
        public HashMap<Node, List<Node>> setMap;

        public MySet(List<Node> nodes){
            for (Node node : nodes) {
                List<Node> myList = new ArrayList<>();
                myList.add(node);
                setMap.put(node, myList);
            }
        }

        public boolean isSameSet(Node fromNode, Node toNode){
            List<Node> fromNodes = setMap.get(fromNode);
            List<Node> toNodes = setMap.get(toNode);
            return fromNodes == toNodes;
        }

        public void union(Node fromNode, Node toNode){
            List<Node> toList = setMap.get(toNode);
            List<Node> fromList = setMap.get(fromNode);
            for (Node node : toList) {
                fromList.add(node);
                setMap.put(node, fromList);
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> kruskalMST(Graph graph){
        MySet mySet = new MySet((List<Node>) graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if (!mySet.isSameSet(edge.from, edge.to)){
                result.add(edge);
                mySet.union(edge.from, edge.to);
            }
        }
        return result;
    }
}
