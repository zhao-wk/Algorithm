package class09;

public class Hanoi {
    public static void main(String[] args) {
        int n = 11;
        process(n, "左","右","中");
    }

    public static void process(int i, String start, String end, String other){
        if (i == 1){
            System.out.println("Move 1 from " + start + " to " + end );
        }else {

            process(i - 1, start, other, end);
            System.out.println("Move " + i + " from " + start + " to " + end);
            process(i - 1, other, end, start);
        }
    }
}
