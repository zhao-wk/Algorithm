package class06;

public class CoinsMin {
    public static void main(String[] args) {
        int[] arr = {3,5,100};
        int aim = 8;
        int res = process(arr, 0, aim);
        System.out.println(res);
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < aim + 1; j++) {
                dp[i][j] = -2;
            }
        }
        int res2 = process2(arr, 0, aim, dp);
        System.out.println(res2);
    }

    public static int process(int[] arr, int index, int rest){
        if (rest < 0){
            return -1;
        }
        if (rest == 0){
            return 0;
        }
        //rest > 0
        if (index == arr.length){
            return -1;
        }
        //rest > 0 有金币
        int p1 = process(arr, index + 1, rest);
        int p2 = process(arr, index + 1, rest - arr[index]);
        if (p1 == -1 && p2 == -1){
            return -1;
        }else {
            if (p1 == -1){
                return p2 + 1;
            }if (p2 == -1){
                return p1;
            }
            return Math.min(p1, p2 + 1);
        }
    }

    public static int process2(int[] arr, int index, int rest, int[][] dp){
        if (rest < 0){
            return -1;
        }
        if (dp[index][rest] != -2){
            return dp[index][rest];
        }

        if (rest == 0){
            dp[index][rest] = 0;
        }else if (index == arr.length){
            dp[index][rest] = -1;
        }else {
            int p1 = process2(arr, index + 1, rest, dp);
            int p2 = process2(arr, index + 1, rest - arr[index], dp);
            if (p1 == -1 && p2 == -1){
                dp[index][rest] = -1;
            }else {
                if (p1 == -1){
                    dp[index][rest] = p2 + 1;
                } else if (p2 == -1) {
                    dp[index][rest] = p1;
                }else {
                    dp[index][rest] = Math.min(p1, p2 + 1);
                }
            }
        }
        return dp[index][rest];
    }
}
