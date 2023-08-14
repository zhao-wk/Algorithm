package class07;

import java.nio.file.LinkPermission;
import java.util.*;

public class SortedTopology {
    public static void main(String[] args) {

    }

    public static List<Node> sortedTopology(Graph graph){
        Queue<Node> zeroQueue = new LinkedList<>();
        HashMap<Node, Integer> inMap = new HashMap<>();

        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0){
                zeroQueue.add(node);
            }
        }

        List<Node> res = new ArrayList<>();

        while (!zeroQueue.isEmpty()){
            Node cur = zeroQueue.poll();
            res.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0){
                    zeroQueue.add(next);
                }
            }
        }
        return res;
    }
}
