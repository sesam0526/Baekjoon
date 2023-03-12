package DFS_BFS;

import java.io.*;
import java.util.*;

public class Problem2667 {
    static int[][] map;
    static boolean[][] visited;
    static int[] apart;
    static int N;
    static int apartNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        apart = new int[N * N];

        for (int i = 0; i < N; i++) {
            String input = in.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    apartNum++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(apartNum);

        Arrays.sort(apart);
        for (int i = 0; i < apart.length; i++) {
            if (apart[i] != 0)
                System.out.println(apart[i]);
        }
    }

    public static void dfs(int X, int Y) {
        int dirX[] = {0, 0, -1, +1};
        int dirY[] = {-1, +1, 0, 0};

        visited[X][Y] = true;
        apart[apartNum]++;

        for (int i = 0; i < 4; i++) {
            int nowX = X + dirX[i];
            int nowY = Y + dirY[i];

            if (nowX < N && nowX >= 0 && nowY < N && nowY >= 0) {
                if (!visited[nowX][nowY] && map[nowX][nowY] == 1)
                    dfs(nowX, nowY);
            }
        }
    }
}