package class05;

public class AddMinusMultiDivide {
    public static void main(String[] args) {
        int add = add(6,-3);
        int minus = minus(6, -3);
        int multi = multi(6, -3);
        int divide = divide(-2147483648, -1);

        System.out.println("ADD: " + add);
        System.out.println("MINUS: " + minus);
        System.out.println("MULTI: " + multi);
        System.out.println("DIVIDE: " + divide);
    }

    public static int add(int a, int b){
        int sum = a;
        while (b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int minus(int a, int b){
        return add(a, negNum(b));
    }

    public static int multi(int a, int b){
        int res = 0;
        while (b != 0){
            if ((b & 1) != 0){
                res = add(res, a);
            }
            a = a << 1;
            b = b >>> 1;
        }
        return res;
    }

    public static int div(int a, int b){
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i--){
            if ((x >> i) >= y){
                res |= (1 << i);
                x = minus(x, y<<i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new RuntimeException("divisor is 0");
        }
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        } else if (divisor == Integer.MIN_VALUE) {
            return 0;
        } else if (dividend == Integer.MIN_VALUE) {
            int res = div(add(dividend, 1), divisor);
            return add(res, div(minus(dividend, multi(res, divisor)), divisor));
        } else {
            return div(dividend, divisor);
        }
    }

    public static int negNum(int a){
        return add(~a, 1);
    }

    public static boolean isNeg(int a){
        return a < 0;
    }
}
