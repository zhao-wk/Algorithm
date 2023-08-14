package class08;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrayArrange {
    public static void main(String[] args) {

    }
    public static class Program{
        public int start;
        public int end;
        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArray(Program[] programs, int startTime){
        int result = 0;
        Arrays.sort(programs, new ProgramComparator());

        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start <= startTime){
                startTime = programs[i].end;
                result++;
            }
        }
        return result;
    }

}
