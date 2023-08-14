package class01;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,3,9,4,6,8,5};
        for (int i = 1; i < arr.length; i++){
            for (int j = i - 1;j >= 0 && arr[j] > arr[j + 1]; j--){
                swap(arr, j, j + 1);
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
