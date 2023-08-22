package class03;

public class Manacher {
    public static void main(String[] args) {
        String s = "babad";
        int res = manacher(s);
        System.out.println(res);
    }

    public static char[] getArray(String s){
        char[] arr = s.toCharArray();
        char[] str = new char[arr.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            str[i] = (i & 1) == 0 ? '#' : arr[index++];
        }
        return str;
    }

    public static int manacher(String s){
        if (s == null || s.length() == 0){
            return 0;
        }

        char[] str = getArray(s);
        int[] pArr = new int[str.length];
        int C = -1;
        int R = -1;
        int max = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;

        for (int i = 0; i != str.length; i++) {
            pArr[i] = R > i ? Math.min(R - i, pArr[2 * C - i]) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1){
                if (str[i + pArr[i]] == str[i - pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
            if (pArr[i] > max){
                maxC = C;
                max = pArr[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxC - pArr[maxC] + 1; i < maxC + pArr[maxC]; i++){
            if (str[i] != '#'){
                sb.append(str[i]);
            }
        }
        System.out.println(sb);
        return max - 1;
    }
}
