package class07;

public class HorseJump {
    public static void main(String[] args) {
        int x = 6, y = 6;
        int step = 10;
        System.out.println(jump1(x,y,step));
        System.out.println(jump2(x,y,step));
    }

    public static int jump1(int x, int y, int step){
        //要去到(x,y)位置，也就是找上一个可以一步跳到(x,y)的位置
        if (x < 0 || x > 8 || y < 0 || y > 9){
            return 0;
        }

        if (step == 0){
            return (x == 0 && y == 0) ? 1 : 0;
        }
        return jump1(x + 2, y + 1, step - 1) +
                jump1(x + 2, y - 1, step - 1) +
                jump1(x + 1, y + 2, step - 1) +
                jump1(x + 1, y - 2, step - 1) +
                jump1(x - 1, y + 2, step - 1) +
                jump1(x - 1, y - 2, step - 1) +
                jump1(x - 2, y + 1, step - 1) +
                jump1(x - 2, y - 1, step - 1);
    }

    public static int jump2(int x, int y, int step){
        if (x < 0 || x > 8 || y < 0 || y > 9){
            return 0;
        }
        int[][][] dp = new int[9][10][step + 1];
        dp[0][0][0] = 1;
        for (int height = 1; height < step + 1; height++) {
            //每一层的所有格子
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 10; j++) {
                    dp[i][j][height] +=  getValue(dp, i + 2, j + 1, height - 1);
                    dp[i][j][height] +=  getValue(dp, i + 2, j - 1, height - 1);
                    dp[i][j][height] +=  getValue(dp, i + 1, j + 2, height - 1);
                    dp[i][j][height] +=  getValue(dp, i + 1, j - 2, height - 1);
                    dp[i][j][height] +=  getValue(dp, i - 1, j + 2, height - 1);
                    dp[i][j][height] +=  getValue(dp, i - 1, j - 2, height - 1);
                    dp[i][j][height] +=  getValue(dp, i - 2, j + 1, height - 1);
                    dp[i][j][height] +=  getValue(dp, i - 2, j - 1, height - 1);
                }
            }
        }
        return dp[x][y][step];
    }

    public static int getValue(int[][][] dp, int row, int col, int height){
        if (row < 0 || row > 8 || col < 0 || col > 9){
            return 0;
        }
        return dp[row][col][height];
    }
}
