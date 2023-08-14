package class03;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {17,21,35,76,100,34,87,70};
        int digit = maxBites(arr);
        radixSort(arr, 0, arr.length - 1, digit);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int maxBites(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0){
            max /= 10;
            res++;
        }
        return res;
    }

    public static void radixSort(int[] arr, int L, int R, int digit){
        int[] help = new int[R - L + 1];
        final int radix = 10;
        for (int d = 1; d <= digit; d++){
            int[] count = new int[radix];

            for (int i = L; i <= R; i++){
                int j = getDigit(arr[i], d);
                count[j]++;
            }

            for (int i = 1; i < count.length; i++){
                count[i] += count[i - 1];
            }

            for (int i = R; i >= 0; i--){
                int j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }

            for (int i = 0; i < help.length; i++){
                arr[i] = help[i];
            }
        }
    }

    public static int getDigit(int i, int d){
        int digit = (i / ((int)Math.pow(10, d - 1))) % 10;
        return digit;
    }
}
