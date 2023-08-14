package class07;

import java.util.HashSet;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {

    }

    public static void bfs(Node node){
        if (node == null) return;

        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();

        stack.push(node);
        set.add(node);
        System.out.println(node.value);

        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
