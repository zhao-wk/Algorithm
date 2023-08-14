package class02;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,3,4,3,2,5,3,5};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }


    }

    public static void quickSort(int[] arr, int i, int j){
        if (i < j){
            int[] index = partition(arr, i, j);
            quickSort(arr, i, index[0] - 1);
            quickSort(arr, index[1] + 1, j);
        }
    }

    public static int[] partition(int[] arr, int left, int right){
        int less = left - 1;
        int more = right;

        while (left < more) {
            if (arr[left] < arr[right]){
                less++;
                swap(arr, less, left);
                left++;
            } else if (arr[left] > arr[right]) {
                more--;
                swap(arr, more, left);
            }else {
                left++;
            }
        }

        swap(arr, more, right);

        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
