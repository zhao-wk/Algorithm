package class03;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,6,5,7};
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void heapSort(int[] arr){
        if (arr == null && arr.length < 2){
            return;
        }
        
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }

        //另一种写法
        for (int i = arr.length -1; i >= 0; i--){
            heapify(arr, i, arr.length);
        }
        
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);

        while (heapSize > 0){
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapify(int[] arr, int index, int heapsize){
        int left = index * 2 + 1;

        while (left < heapsize){
            int largest = left + 1 < heapsize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break;
            }
            
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
