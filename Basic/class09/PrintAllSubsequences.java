package class09;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequences {
    public static void main(String[] args) {
        String test = "hello everyone";
        char[] strs = test.toCharArray();
//        process1(0, "abc".toCharArray());

        process2(strs,0, new ArrayList<Character>(strs.length));
    }


    public static void process1 (int i, char[] strs){
        if (i == strs.length){
            System.out.println(String.valueOf(strs));
            return;
        }

        process1(i + 1, strs);

        char temp = strs[i];
        strs[i] = 0;

        process1(i + 1, strs);

        strs[i] = temp;
    }

    public static void process2(char[] strs, int i, List<Character> result) {
        if (i == strs.length){
            printList(result);
            return;
        }

        List<Character> listKeep = copyList(result);
        listKeep.add(strs[i]);
        process2(strs,i + 1, listKeep);
        List<Character> listNoKeep = copyList(result);
        process2(strs, i + 1, listNoKeep);
    }

    public static void printList(List<Character> list){
        for (Character character : list) {
            System.out.print(character);
        }
        System.out.println();
    }

    public static List<Character> copyList(List<Character> oldList){
        List<Character> newList = new ArrayList<>(oldList.size());
        for (Character character : oldList) {
            newList.add(character);
        }
        return newList;
    }
}
