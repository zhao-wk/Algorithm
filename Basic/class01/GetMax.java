package class01;

public class GetMax {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5,6,4,2,5,9,7,0};
        int max = process(arr, 0, arr.length - 1);
        System.out.println(max);
    }

    public static int process(int[] arr, int left, int right){
        if (left == right){
            return arr[left];
        }

        int mid = left + ((right - left) >> 1);

        int leftMax = process(arr, left, mid);
        int rightMax = process(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }
}
