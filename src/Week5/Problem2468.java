package Week5;

import java.io.*;
import java.util.*;

public class Problem2468 {
    static int[][] map;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        map = new int[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (maxHeight < map[i][j])
                    maxHeight = map[i][j];
            }
        }

        int max = 1;
        for (int height = 0; height < maxHeight; height++) {
            int count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > height) {
                        count++;
                        dfs(i, j, height);
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    public static void dfs(int X, int Y, int height) {
        int dirX[] = {0, 0, -1, +1};
        int dirY[] = {-1, +1, 0, 0};

        visited[X][Y] = true;

        for (int i = 0; i < 4; i++) {
            int nowX = X + dirX[i];
            int nowY = Y + dirY[i];

            if (nowX < N && nowX >= 0 && nowY < N && nowY >= 0) {
                if (!visited[nowX][nowY] && map[nowX][nowY] > height)
                    dfs(nowX, nowY, height);
            }
        }
    }
}