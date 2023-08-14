package class01;

public class BitwiseOperation {
    public static void main(String[] args) {
        int[] one = {1,5,3,4,2,5,2,1,3};
        int err = 0;
        for (int i : one) {
            err ^= i;
        }
        System.out.println(err);

        int[] two = {1,2,5,3,2,4,2,5,2,1,3,9};
        err = 0;
        for (int i : two) {
            err ^= i;
        }
        int rightOne = err & (~err + 1);
        int errPrime = 0;
        for (int i : two) {
            if ((i & rightOne) == 1){
                errPrime ^= i;
            }
        }
        int a = errPrime;
        int b = err ^ errPrime;
        System.out.println(a+ " " + b);
    }

}
