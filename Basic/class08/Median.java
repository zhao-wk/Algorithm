package class08;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        double median = mf.findMedian();
        System.out.println(median);
    }
    public static class MedianFinder {

        public PriorityQueue<Integer> small;
        public PriorityQueue<Integer> big;

        public MedianFinder() {
            small = new PriorityQueue<>();
            big = new PriorityQueue<>(new BigComparator());
        }
        public void addNum (int num){
            if (big.size() == 0) {
                big.add(num);
                return;
            }

            if (num < big.peek()){
                big.add(num);
            }else {
                small.add(num);
            }

            if (big.size() - small.size() >= 2) {
                small.add(big.poll());
            }
            if (small.size() - big.size() >= 2) {
                big.add(small.poll());
            }
        }

        public double findMedian () {
            if (big.size() == small.size()) {
                return (big.peek() + small.peek()) / 2.0;
            } else {
                return big.size() > small.size() ? big.peek() : small.peek();
            }
        }

        public class BigComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }
    }
}
