package DFS_BFS;

import java.io.*;
import java.util.*;

public class Problem1012 {
    static int[][] ground;
    static boolean[][] visited;
    static int N, M, K;

    public static void dfs(int X, int Y) {
        visited[X][Y] = true;

        int[] dirX = {0, 0, -1, +1};
        int[] dirY = {-1, +1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nowX = X + dirX[i];
            int nowY = Y + dirY[i];

            if (nowX < M && nowX >= 0 && nowY < N && nowY >= 0) {
                if (!visited[nowX][nowY] && ground[nowX][nowY] == 1)
                    dfs(nowX, nowY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(in.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            ground = new int[M][N];
            visited = new boolean[M][N];

            K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(in.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                ground[X][Y] = 1;
            }

            int count = 0;
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && ground[j][k] == 1) {
                        count++;
                        dfs(j, k);
                    }
                }
            }
            System.out.println(count);
        }
    }
}
