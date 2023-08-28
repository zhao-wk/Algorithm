package class07;

public class BobDie {
    public static void main(String[] args) {
        int k = 5, M = 13, N = 13, i = 3, j = 2;
        int live1 = bob1(M, N, i, j, k);
        int live2 = bob2(M, N, i, j, k);
        System.out.println(live1 == live2);
    }

    public static int bob1(int M, int N, int row, int col, int step){
        if (row < 0 || row == M || col < 0 || col == N){
            return 0;
        }
        if (step == 0){
            return 1;
        }

        int live = 0;
        live += bob1(M, N, row + 1, col, step - 1);
        live += bob1(M, N, row - 1, col, step - 1);
        live += bob1(M, N, row, col + 1, step - 1);
        live += bob1(M, N, row, col - 1, step - 1);
        return live;
    }

    public static int bob2(int M, int N, int row, int col, int step){
        if (row < 0 || row == M || col < 0 || col == N){
            return 0;
        }

        int[][][] dp = new int[M + 2][N + 2][step + 1];

        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int height = 1; height < step + 1; height++) {
            //每一层所有格子
            for (int i = 1; i < M + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    int res = 0;
                    res += dp[i + 1][j][height - 1];
                    res += dp[i - 1][j][height - 1];
                    res += dp[i][j + 1][height - 1];
                    res += dp[i][j - 1][height - 1];
                    dp[i][j][height] = res;
                }
            }
        }
        return dp[row + 1][col + 1][step];
    }
}
