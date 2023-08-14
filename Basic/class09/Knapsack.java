package class09;

public class Knapsack {
    public static void main(String[] args) {
        int[] weight = {1,2,3,4,5};
        int[] values = {1,4,7,9,10 };
        int bag = 5;
        System.out.println(process2(weight, values, 0, 0, 0, bag));
    }

    public static int process1(int[] weight, int [] values, int i, int alreadyWeight, int bag){
        if (alreadyWeight > bag){
            return -values[i - 1];
        }
        if (i == weight.length){
            return 0;
        }

        return Math.max(
                process1(weight, values, i + 1, alreadyWeight, bag),
                values[i] + process1(weight, values, i + 1, alreadyWeight + weight[i], bag)
        );
    }

    public static int process2(int[] weight, int[] values, int i, int alreadyWeight, int alreadyValues, int bag){
        if (alreadyWeight > bag){
            return 0;
        }
        if (i == weight.length){
            return alreadyValues;
        }

        return Math.max(
                process2(weight, values, i + 1, alreadyWeight, alreadyValues, bag),
                process2(weight, values, i + 1, alreadyWeight + weight[i], alreadyValues + values[i], bag)
        );
    }
}
