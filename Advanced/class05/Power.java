package class05;

public class Power {
    public static void main(String[] args) {
        boolean res = is4Power(128);
        System.out.println(res);
    }

    public static boolean is2Power(int a){
        return (a & (a - 1) ) == 0;
    }

    public static boolean is4Power(int a){
        return (a & (a - 1)) == 0 && ((a & 0x55555555) == 0);
    }
}
