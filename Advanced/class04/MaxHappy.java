package class04;

import java.util.List;

public class MaxHappy {
    public static void main(String[] args) {

    }

    public static class Employee{
        public int happy;
        public List<Employee> nexts;

        public Employee(int happy){
            this.happy = happy;
        }
    }

    public static class Info{
        public int comeMax;
        public int noComeMax;
        public Info(int come, int noCome){
            this.comeMax = come;
            this.noComeMax = noCome;
        }
    }

    public static Info process(Employee x){
        if (x.nexts == null){
            return new Info(x.happy, 0);
        }

        int come = x.happy;
        int noCome = 0;

        for (Employee next : x.nexts) {
            Info info = process(next);
            come += info.noComeMax;
            noCome += Math.max(info.comeMax, info.noComeMax);
        }

        return new Info(come, noCome);
    }
}
