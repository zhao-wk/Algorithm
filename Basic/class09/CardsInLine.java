package class09;

public class CardsInLine {
    //递归版本
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,6,5};
        int first = first(arr, 0, arr.length - 1);
        int second = second(arr, 0, arr.length - 1);
        System.out.println("first = " + first);
        System.out.println("second = " + second);
    }

    public static int first(int[] arr, int p, int q){
        if (p == q){
            return arr[p];
        }

        return Math.max(second(arr, p + 1, q) + arr[p], second(arr, p, q - 1) + arr[q]);
    }

    public static int second(int[] arr, int p, int q){
        if (p == q){
            return 0;
        }

        return Math.min(first(arr, p + 1, q), first(arr, p, q - 1));
    }
}
