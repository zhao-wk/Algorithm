package class07;

public class CoinsMin {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int aim = 5;
        int res1 = coins1(coins, 0, aim);
        System.out.println(res1);
        int res2 = coins2(coins, aim);
        System.out.println(res2);
        int res3 = coins3(coins, aim);
        System.out.println(res3);
        int res4 = coins4(coins, aim);
        System.out.println(res4);
    }

    public static int coins1(int[] arr, int index, int rest){
        if (index == arr.length){
            return rest == 0 ? 0 : -1;
        }

        int res = -1;

        for (int k = 0; k * arr[index] <= rest; k++){
            int next = coins1(arr, index + 1, rest - k * arr[index]);
            if (next != -1){
                res = res == -1 ? next + k : Math.min(res, next + k);
            }
        }
        return res;
    }

    public static int coins2(int[] arr, int rest){
        int N = arr.length;
        int[][] dp = new int[N + 1][rest + 1];

        for (int col = 1; col < rest + 1; col++){
            dp[N][col] = -1;
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < rest + 1; j++) {
                dp[i][j] = -1;
                if (dp[i + 1][j] != -1){
                    dp[i][j] = dp[i + 1][j];
                }

                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != -1){
                    if (dp[i][j] == -1){
                        dp[i][j] = dp[i][j - arr[i]] + 1;
                    }else
                        dp[i][j] = Math.min(dp[i][j - arr[i]] + 1, dp[i][j]);
                }
            }
        }

        return dp[0][rest];
    }

    public static int coins3(int[] arr, int aim){
        if (arr == null || arr.length == 0){
            return 0;
        }

        int N = arr.length;

        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int i = N - 1; i >= 0; i--){
            for (int rest = 0; rest < aim + 1; rest++) {
                int ways = 0;
                for (int k = 0; arr[i] * k <= rest; k++){
                    ways += dp[i + 1][rest - k * arr[i]];
                }
                dp[i][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    public static int coins4(int[] arr, int aim){
        if (arr == null || arr.length == 0){
            return 0;
        }

        int N = arr.length;

        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int i = N - 1; i >= 0; i--){
            for (int rest = 0; rest < aim + 1; rest++) {
                dp[i][rest] = dp[i + 1][rest];
                if (rest - arr[i] >= 0){
                    dp[i][rest] += dp[i][rest - arr[i]];
                }
            }
        }
        return dp[0][aim];
    }


}
