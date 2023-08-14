package class09;

import java.util.HashMap;
import java.util.Map;

public class Dijkstra2 {
    public static void main(String[] args) {

    }

    public static class NodeRecord{
        public Node node;
        public int distance;
        public NodeRecord(Node node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public static class NodeHeap{
        public Node[] nodes;
        public HashMap<Node, Integer> nodeIndex;
        public HashMap<Node, Integer> distanceMap;
        public int size;

        public NodeHeap(int size){
            nodes = new Node[size];
            nodeIndex = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = size;
        }

        public void insertOrUpdateOrIgnore(Node node, int distance){
            if (inHeap(node)){
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                heapInsert(nodeIndex.get(node));
            }
            if (!isEntered(node)){
                nodes[size] = node;
                distanceMap.put(node, distance);
                nodeIndex.put(node,size);
                heapInsert(size);
                size++;
            }
        }

        public void heapInsert(int index){
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])){
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public void heapify(int index, int size){
            int left = index * 2  + 1;
            while (left < size){
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
                        ? left + 1 : left;
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
                if (smallest == index){
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;

            }
        }

        public NodeRecord pop(){
            NodeRecord result = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0, size - 1);
            nodeIndex.put(nodes[size -1], -1);
            distanceMap.remove(nodes[size - 1]);
            nodes[size - 1] = null;
            heapify(0, --size);
            return result;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public boolean inHeap(Node node){
            return isEntered(node) && nodeIndex.get(node) != -1;
        }

        public boolean isEntered(Node node){
            return nodeIndex.containsKey(node);
        }

        public void swap (int index1, int index2){
            nodeIndex.put(nodes[index1], index2);
            nodeIndex.put(nodes[index2], index1);
            Node temp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = temp;
        }


    }

    public static Map<Node, Integer>dijkstra2(Node head, int size){
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.insertOrUpdateOrIgnore(head, 0);
        HashMap<Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()){
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.insertOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
    }
}
