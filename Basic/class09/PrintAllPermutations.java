package class09;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {
    public static void main(String[] args) {
        String text = "abcb";
        char[] strs = text.toCharArray();
        List<String> result = new ArrayList<>();
        process(strs, 0, result);
        for (String s : result) {
            System.out.println(s);
        }

    }

    public static void process(char[] strs, int i, List<String> result){
        if (strs.length == i){
            result.add(String.valueOf(strs));

        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < strs.length; j++){
            if (!visit[strs[j] - 'a']){
                visit[strs[j] - 'a'] = true;
                swap(i, j ,strs);
                process(strs, i+1, result);
                swap(i, j, strs);

            }
        }
    }
    public static void swap(int i, int j, char[] strs){
        char temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }


}
