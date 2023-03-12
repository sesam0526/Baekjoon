package DFS_BFS;

import java.io.*;
import java.util.*;

public class Problem2178 {
    static Queue<int[]> q;
    static int[][] map;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = in.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }

    public static void bfs(int X, int Y) {
        q = new LinkedList<>();
        q.add(new int[]{X, Y});

        int dirX[] = {0, 0, -1, +1};
        int dirY[] = {-1, +1, 0, 0};

        visited[X][Y] = true;

        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dirX[i];
                int nextY = nowY + dirY[i];

                if (nextX < N && nextX >= 0 && nextY < M && nextY >= 0) {
                    if (!visited[nextX][nextY] && map[nextX][nextY] != 0) {
                        visited[nextX][nextY] = true;
                        map[nextX][nextY] = map[nowX][nowY] + 1;
                        q.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}