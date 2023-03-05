package Week5;

import java.io.*;
import java.util.*;

public class Problem10026 {
    static char[][] map;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = in.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int normal_count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    normal_count++;
                    dfs(i, j);
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        int abnormal_count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    abnormal_count++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(normal_count + " " + abnormal_count);
    }

    public static void dfs(int X, int Y) {
        int dirX[] = {0, 0, -1, +1};
        int dirY[] = {-1, +1, 0, 0};

        visited[X][Y] = true;
        char tmp = map[X][Y];

        for (int i = 0; i < 4; i++) {
            int nowX = X + dirX[i];
            int nowY = Y + dirY[i];

            if (nowX < N && nowX >= 0 && nowY < N && nowY >= 0) {
                if (!visited[nowX][nowY] && map[nowX][nowY] == tmp)
                    dfs(nowX, nowY);
            }
        }
    }
}