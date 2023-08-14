package class08;

public class NQueens {
    public static void main(String[] args) {
        int result = start(15);
        System.out.println(result);
    }
    public static int start(int n){
        int[] record = new int[n];
        return process1(0, record, n);
//        int limit = (1 << n) - 1;
//        return process2(limit, 0, 0, 0);
    }

    public static int process1(int i, int[] record, int n){
        if (i == n){
            return 1;
        }

        int res = 0;

        for (int j = 0; j < n; j++) {
            if (isValid(i, j ,record)){
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    public static boolean isValid(int i, int j, int[] record){
        for (int k = 0; k < i; k++){
            if (j == record[k] || Math.abs(i - k) == Math.abs(j - record[k])){
                return  false;
            }
        }
        return true;
    }

    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim){
        if (colLim == limit) return 1;

        int res = 0;

        int pos =limit & (~(colLim | leftDiaLim| rightDiaLim));
        int rightZero = 0;
        while (pos != 0){
            rightZero = pos & (~pos + 1);
            pos -= rightZero;
            res += process2(limit,
                    (colLim | rightZero),
                    (leftDiaLim | rightZero) << 1,
                    (rightDiaLim | rightZero) >>> 1);
        }
        return res;
    }

}
