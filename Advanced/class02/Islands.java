package class02;

public class Islands {
    public static void main(String[] args) {
        int[][] m1 = {{1,1,0,0,0,0,1,1},
                      {1,1,1,0,0,0,0,1},
                      {1,1,0,0,0,0,1,1},
                      {1,1,1,1,0,0,0,0},
                      {1,0,0,0,0,0,1,0}};
        int res = islands(m1);
        System.out.println(res);

    }

    public static int islands(int[][] m){
        int M = m.length;
        int N = m[0].length;
        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (m[i][j] == 1){
                    res ++;
                    infect(m, i, j, M, N);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j, int M, int N){
        if (i < 0 || i >= M || j < 0 || j >= N || m[i][j] != 1){
            return;
        }

        m[i][j] = 2;
        infect(m, i + 1, j, M, N);
        infect(m, i - 1, j, M, N);
        infect(m, i, j + 1, M, N);
        infect(m, i, j - 1, M, N);
    }
}
