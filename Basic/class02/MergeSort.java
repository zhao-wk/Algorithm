package class02;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1,4,2,3,6,5,8,2,7};
        process(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void process(int[] arr, int left, int right){
        if (left == right){
            return;
        }
        int mid = left + ((right - left) >> 1);

        process(arr, left, mid);
        process(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }
    public static void merge(int[] arr, int left, int mid, int right){
        int[] help = new int[right - left +1];
        int index = 0;
        int leftPointer = left;
        int rightPointer = mid + 1;

        while (leftPointer <= mid && rightPointer <= right){
            if (arr[leftPointer] <= arr[rightPointer]){
                help[index] = arr[leftPointer];
                index++;
                leftPointer++;
            }else {
                help[index] = arr[rightPointer];
                index++;
                rightPointer++;
            }
        }

        while (leftPointer <= mid){
            help[index++] = arr[leftPointer++];
        }
        while (rightPointer <= right){
            help[index++] = arr[rightPointer++];
        }

        for (int i = 0; i < help.length; i++){
            arr[left + i] = help[i];
        }
    }
}
