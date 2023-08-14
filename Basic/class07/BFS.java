package class07;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {

    }

    public static void bfs(Node node){
        if (node == null) return;

        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();

        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)){
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }
}
