package class08;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicography {
    public static void main(String[] args) {
        String[] strs = {"jibw", "ji", "jp", "bw", "jibw"};
        String result = lowestString(strs);
        System.out.println(result);
        String[] strs2 = {"b", "ba"};
        result = lowestString(strs2);
        System.out.println(result);
    }
    public static String lowestString(String[] strs){
        if (strs.length == 0 || strs == null) return null;

        Arrays.sort(strs, new StrComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    public static class StrComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }
}
