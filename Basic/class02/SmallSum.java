package class02;

public class SmallSum {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        int sum = process(arr, 0, arr.length - 1);
        System.out.println(sum);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int process(int[] arr, int left, int right){
        if (left == right){
            return 0;
        }

        int mid = left + (( right - left) >> 1);

        return  process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int index = 0;
        int leftPointer = left;
        int rightPointer = mid + 1;
        int result = 0;

        while (leftPointer <= mid && rightPointer <= right){
            if (arr[leftPointer] < arr[rightPointer]){
                result += arr[leftPointer] * (right - rightPointer + 1);
                help[index++] = arr[leftPointer++];
            }
            else {
                help[index++] = arr[rightPointer++];
            }
        }
        while (leftPointer <= mid){
            help[index++] = arr[leftPointer++];
        }
        while (rightPointer <= right){
            help[index++] = arr[rightPointer++];
        }

        for(int i = 0; i < help.length; i++){
            arr[left + i] = help[i];
        }

        return result;
    }
}
