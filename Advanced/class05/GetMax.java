package class05;

public class GetMax {
    public static void main(String[] args) {
        int res = getMax(31, -30);
        System.out.println(res);
    }

    public static int flip(int a){
        return a ^ 1;
    }

    public static int sign(int a){
        return flip((a >>> 31) & 1);
    }

    public static int getMax(int a, int b){
        int c = a - b;
        int scA = sign(a);
        int scB = sign(b);
        int scC = sign(c);
        int difSab = scA ^ scB;
        int sameSab = flip(difSab);
        int returnA = difSab * scA + sameSab * scC;
        int returnB = flip(returnA);

        return a * returnA + b * returnB;
    }
}
