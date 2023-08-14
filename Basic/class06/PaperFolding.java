package class06;

public class PaperFolding {
    public static void main(String[] args) {
        int N = 3;
        fold(1, N, true);
    }

    public static void fold(int i, int N, boolean down){
        if (i > N) return;

        fold(i + 1, N, true);
        System.out.println(down ? "凹" : "凸");
        fold(i + 1, N, false);
    }
}
