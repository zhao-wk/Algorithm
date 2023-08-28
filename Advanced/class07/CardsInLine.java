package class07;

public class CardsInLine {
    public static void main(String[] args) {
        int len = 10;
        int max = 10;
        int testTime = 10000;
        System.out.println("start");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(len, max);
            if (win1(arr) != win2(arr)){
                System.out.println("error");
            }
        }
    }

    public static int win1(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
    }

    public static int first(int[] arr, int L, int R){
        if (L == R){
            return arr[L];
        }
        return Math.max(second(arr, L + 1, R) + arr[L], second(arr, L, R - 1) + arr[R]);
    }
    public static int second(int[] arr, int L, int R){
        if (L == R){
            return 0;
        }
        return Math.min(first(arr, L + 1, R), first(arr, L, R - 1));
    }

    public static int win2(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];

        for (int R = 0; R < arr.length; R++) {
            f[R][R] = arr[R];
            for (int L = R - 1; L >= 0 ; L--) {
                f[L][R] = Math.max(s[L + 1][R] + arr[L], s[L][R - 1] + arr[R]);
                s[L][R] = Math.min(f[L + 1][R], f[L][R - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }

    public static int[] generateRandomArray(int len, int max){
        int[] arr = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) + 1;
        }
        return arr;
    }

}
