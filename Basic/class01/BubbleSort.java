package class01;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,3,9,4,6,8,5};
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (arr[j] > arr[i]){
                    swap(arr, i ,j);
                }
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
