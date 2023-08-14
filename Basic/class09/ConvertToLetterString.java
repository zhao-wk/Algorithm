package class09;

public class ConvertToLetterString {
    public static void main(String[] args) {
        String s = "111";
        char[] strs = s.toCharArray();
        int result = process(strs, 0);
        System.out.println(result);
    }

    public static int process(char[] strs, int i){
        if (i == strs.length){
            return 1;
        }
        if (strs[i] == '0'){
            return 0;
        }
        if (strs[i] == '1'){
            int res = process(strs, i + 1);
            if (i + 1 < strs.length){
                res += process(strs, i + 2);
            }
            return res;
        }

        if (strs[i] == '2'){
            int res = process(strs, i + 1);
            if (i + 1 < strs.length && (strs[i + 1] >= 0 && strs[i + 1] <= 6)){
                res += process(strs, i + 2);
            }
        }
        return process(strs, i + 1);
    }
}
