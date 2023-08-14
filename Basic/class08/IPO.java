package class08;

import java.io.NotActiveException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static void main(String[] args) {

    }

    public static class Node{
        public int cost;
        public int benefit;
        public Node(int cost, int benefit){
            this.cost = cost;
            this.benefit = benefit;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    public static class MaxBenefitComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.benefit - o1.benefit;
        }
    }

    public static int ipo(int k, int w, int[] costs, int[] benefits){
        PriorityQueue<Node> cost = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> benefit = new PriorityQueue<>(new MaxBenefitComparator());

        for (int i = 0; i < costs.length; i++) {
            cost.add(new Node(costs[i], benefits[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!cost.isEmpty() && cost.peek().cost <= w){
                benefit.add(cost.poll());
            }
            if (benefit.isEmpty()){
                return w;
            }
            w += benefit.poll().benefit;
        }
        return w;
    }
}
