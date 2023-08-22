package class03;

import java.util.LinkedList;

public class GetMaxWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] window = getWindow(nums, 3);
        for (int i : window) {
            System.out.println(i);
        }
    }
    public static int[] getWindow(int[] nums, int k){
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> qMax = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[i]){
                qMax.pollLast();
            }
            qMax.addLast(i);
            if (qMax.peekFirst() == i - k){
                qMax.pollFirst();
            }
            if (i >= k - 1){
                res[index++] = nums[qMax.peekFirst()];
            }
        }
        return res;
    }
}
