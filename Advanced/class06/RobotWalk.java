package class06;

public class RobotWalk {
    public static void main(String[] args) {
        //N -> 一共几个格子 E -> 终点 S -> 起点 K -> 走多少步
        int N = 5, E = 4, S = 2, K = 4;
        System.out.println(f(N, E, K, S));
        //rest cur
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i < K + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                dp[i][j] = -1;
            }
        }
        int res2 = f2(N, E, K, S, dp);
        System.out.println(res2);
    }

    public static int f(int N, int E, int rest, int cur){
        if (rest == 0){
            return cur == E ? 1 : 0;
        }
        if (cur == 1){
            return f(N, E, rest - 1, 2);
        }
        if (cur == N){
            return f(N, E, rest - 1, N -1);
        }
        return f(N, E, rest - 1, cur + 1) + f(N, E, rest - 1, cur - 1);
    }

    public static int f2 (int N, int E, int rest, int cur, int[][] dp){
        if (dp[rest][cur] != -1){
            return dp[rest][cur];
        }
        if (rest == 0){
            dp[rest][cur] = cur == E ? 1 : 0;
            return dp[rest][cur];
        }
        if (cur == 1){
            dp[rest][cur] = f2(N, E, rest - 1, 2, dp);
        } else if (cur == N) {
            dp[rest][cur] = f2(N, E, rest - 1, N - 1, dp);
        }else {
            dp[rest][cur] = f2(N, E, rest - 1, cur + 1, dp) + f2(N, E, rest - 1, cur - 1, dp);
        }
        return dp[rest][cur];
    }
}
