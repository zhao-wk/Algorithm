package class08;

import java.util.PriorityQueue;

public class LessMoneySplitGold {
    public static void main(String[] args) {

    }

    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int cur = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        while (queue.size() > 1){
            cur = queue.poll() + queue.poll();
            sum += cur;
            queue.add(cur);
        }
        return sum;
    }
}
